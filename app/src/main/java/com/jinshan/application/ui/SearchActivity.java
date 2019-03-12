package com.jinshan.application.ui;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jinshan.application.Constant;
import com.jinshan.application.R;
import com.jinshan.application.base.BaseActivity;
import com.jinshan.application.entity.ProductEntity;
import com.jinshan.application.entity.SearchEntity;
import com.jinshan.application.http.ProductProvider;
import com.minilive.library.adapter.BaseViewHolderHelper;
import com.minilive.library.adapter.recycler.BaseRecyclerAdapter;
import com.minilive.library.adapter.recycler.OnRecyclerItemClickListener;
import com.minilive.library.entity.EventData;
import com.minilive.library.http.callback.OnJsonCallBack;
import com.minilive.library.util.StringUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;

public class SearchActivity extends BaseActivity {
    @BindView(R.id.etSearch)
    EditText etSearch;
    @BindView(R.id.layoutSearch)
    LinearLayout layoutSearch;
    @BindView(R.id.tvSearch)
    TextView tvSearch;
    @BindView(R.id.rvSearch)
    RecyclerView rvSearch;

    private ClassifyAdapter classifyAdapter;


    @Override
    protected boolean isRegisterEventBus() {
        return false;
    }

    @Override
    protected void initViewAndData() {
        ButterKnife.bind(this);

        rvSearch.setLayoutManager(new LinearLayoutManager(this));
        classifyAdapter = new ClassifyAdapter(rvSearch);
        rvSearch.setAdapter(classifyAdapter);
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected View getLoadingTargetView() {
        return findViewById(R.id.layoutContent);
    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_search;
    }


    @OnClick(R.id.tvSearch)
    public void onViewClicked() {
        String key = etSearch.getText().toString();
        if (StringUtils.isEmpty(key)) {
            showToast("请输入关键字");
            return;
        }
        showLoading("");
        ProductProvider.search(this, key, new OnJsonCallBack() {
            @Override
            public void onResult(Object data) {
                reStoreView();
                try {
                    JSONObject jsonObject = new JSONObject(data.toString());
                    String kou = jsonObject.getString("口子");
                    String xilie = jsonObject.getString("系列");
                    List<ProductEntity> kouEntity = new Gson().fromJson(kou,
                            new TypeToken<List<ProductEntity>>() {
                            }.getType());

                    for (int i = 0;i < kouEntity.size();i++){
                        kouEntity.get(i).setMyCustomTag(1);
                    }

                    List<ProductEntity> xEntity = new Gson().fromJson(xilie,
                            new TypeToken<List<ProductEntity>>() {
                            }.getType());

                    for (int i = 0;i < xEntity.size();i++){
                        xEntity.get(i).setMyCustomTag(2);
                    }

                    List<SearchEntity> searchEntities = new ArrayList<>();
                    SearchEntity searchEntity = new SearchEntity();
                    searchEntity.title = "口子";
                    searchEntity.entityList = kouEntity;
                    searchEntities.add(searchEntity);

                    searchEntity = new SearchEntity();
                    searchEntity.title = "系列";
                    searchEntity.entityList = xEntity;
                    searchEntities.add(searchEntity);
                    classifyAdapter.setData(searchEntities);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    class ClassifyAdapter extends BaseRecyclerAdapter<SearchEntity> {

        public ClassifyAdapter(RecyclerView recyclerView) {
            super(recyclerView, R.layout.item_home);
        }

        @Override
        protected void fillData(BaseViewHolderHelper helper, int position, final SearchEntity model) {
            helper.setText(R.id.tvTitle, model.title);
            RecyclerView rvList = helper.getView(R.id.rvList);
            rvList.setFocusable(false);
            rvList.setFocusableInTouchMode(false);
            rvList.setLayoutManager(new GridLayoutManager(mContext, 4));
            SearchAdapter homeAdapter = new SearchAdapter(rvList);
            rvList.setAdapter(homeAdapter);
            homeAdapter.setData(model.entityList);

            homeAdapter.setOnRVItemClickListener(new OnRecyclerItemClickListener() {
                @Override
                public void onItemClick(ViewGroup parent, View itemView, int position) {
                    ProductEntity entity = model.entityList.get(position);
                    if (entity.getMyCustomTag() == 1){
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("data" , entity);
                        jumpTo(ProductDetailActivity.class , bundle);
                    } else {
                        EventData eventData = new EventData(Constant.CODE_CLASSIFY, entity.getId());
                        EventBus.getDefault().post(eventData);
                        finish();
                    }
                }
            });

        }
    }


    class SearchAdapter extends BaseRecyclerAdapter<ProductEntity> {

        public SearchAdapter(RecyclerView recyclerView) {
            super(recyclerView, R.layout.item_home_bean);
        }

        @Override
        protected void fillData(BaseViewHolderHelper helper, int position, ProductEntity model) {
            Glide.with(mContext).load(Constant.BASEURL + model.getImageUrl()).into(helper.getImageView(R.id.ivLable));
            helper.setText(R.id.tvName, model.getName());
        }
    }

}
