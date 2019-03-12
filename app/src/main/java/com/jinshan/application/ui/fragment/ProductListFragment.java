package com.jinshan.application.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jinshan.application.Constant;
import com.jinshan.application.R;
import com.jinshan.application.base.BaseFragment;
import com.jinshan.application.entity.ProductEntity;
import com.jinshan.application.entity.ProductResult;
import com.jinshan.application.entity.RecommandEntity;
import com.jinshan.application.http.ProductProvider;
import com.jinshan.application.ui.HomeActivity;
import com.jinshan.application.ui.ProductDetailActivity;
import com.minilive.library.BaseAdapterUtil;
import com.minilive.library.adapter.BaseViewHolderHelper;
import com.minilive.library.adapter.list.BaseListAdapter;
import com.minilive.library.http.callback.OnJsonCallBack;
import com.minilive.library.util.StringUtils;
import com.minilive.library.util.TimeUtil;
import com.minilive.library.util.Trace;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

@SuppressLint("ValidFragment")
public class ProductListFragment extends BaseFragment implements OnRefreshListener, OnLoadMoreListener {

    @BindView(R.id.gvProduct)
    GridView gvProduct;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    Unbinder unbinder;
    private RecommandEntity mRecommandEntity;

    private int mCurrentPage = 1;

    public ProductListFragment(RecommandEntity recommandEntity) {
        mRecommandEntity = recommandEntity;
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_product_list;
    }

    private ListAdapter mListAdapter;

    @Override
    protected void initViewAndData() {
        mListAdapter = new ListAdapter(getActivity());
        gvProduct.setAdapter(mListAdapter);
        gvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ProductEntity entity = mListAdapter.getItem(position);
                Bundle bundle = new Bundle();
                bundle.putSerializable("data" , entity);
                jumpTo(ProductDetailActivity.class,bundle);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    protected void onFirstUserVisible() {
        super.onFirstUserVisible();
        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setOnLoadMoreListener(this);
        refreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                refreshLayout.autoRefresh();
            }
        }, 500);
    }

    private void getData() {
        ProductProvider.getProductList(this, String.valueOf(mRecommandEntity.getId()),
                mCurrentPage, new OnJsonCallBack<ProductResult>() {
                    @Override
                    public void onResult(ProductResult data) {
                        refreshLayout.finishRefresh();
                        refreshLayout.finishLoadMore();
                        if (data != null) {
                            if (data.getResultList()!= null &&
                                    BaseAdapterUtil.isListNotEmpty(data.getResultList().getResultlist())){
                                if (data.getResultList().getResultlist().size() < ProductProvider.LIMIT){
                                    refreshLayout.setEnableLoadMore(false);
                                }
                                if (mCurrentPage == 1){
                                    mListAdapter.setData(data.getResultList().getResultlist());
                                } else {
                                    mListAdapter.addMoreData(data.getResultList().getResultlist());
                                }
                            } else {
                                refreshLayout.setEnableLoadMore(false);
                            }
                        } else {
                            refreshLayout.setEnableLoadMore(false);
                        }
                    }
                });
    }


    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        refreshLayout.setEnableLoadMore(true);
        mCurrentPage = 1;
        getData();
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        mCurrentPage++;
        getData();
    }

    class ListAdapter extends BaseListAdapter<ProductEntity>{

        public ListAdapter(Context context) {
            super(context, R.layout.item_product);
        }

        @Override
        protected void fillData(BaseViewHolderHelper helper, int position, ProductEntity model) {
            Glide.with(mContext).load(Constant.BASEURL + model.getImageUrl()).into(helper.getImageView(R.id.ivProduct));
            helper.setText(R.id.tvName , model.getName())
                    .setText(R.id.tvDraution , model.getCharacteristicLabel());
            if (model.getReturnVisit() == 1){
                helper.setText(R.id.tvBack , "有回访");
                helper.setTextColor(R.id.tvBack, getResources().getColor(R.color.colorAccent));
            } else {
                helper.setText(R.id.tvBack , "无回访");
                helper.setTextColor(R.id.tvBack, getResources().getColor(R.color.gray_80));
            }
            if (!StringUtils.isEmpty(model.getManualTime())) {
                String date = TimeUtil.timeStamp2Date(Long.parseLong(model.getManualTime()), "");
                helper.setText(R.id.tvDate, date);
            } else {
                helper.setText(R.id.tvDate, "");
            }

            int royalty = model.getRoyalty();
            int next = model.getNextCommission();
            TextView tvHotTag = helper.getTextView(R.id.tvHotTag);
            if (royalty > 0 && next > 0){
                tvHotTag.setVisibility(View.VISIBLE);
                tvHotTag.setBackgroundResource(R.drawable.bg_product_tag);
                tvHotTag.setText("今日热门");
            } else {
                if (royalty > 0){
                    tvHotTag.setVisibility(View.VISIBLE);
                   // tvHotTag.setTextColor(getResources().getColor(R.color.white));
                    tvHotTag.setBackgroundResource(R.drawable.bg_product_tag);
                    tvHotTag.setText("今日热门");
                } else  if (next > 0){
                    tvHotTag.setVisibility(View.VISIBLE);
                   // tvHotTag.setTextColor(Color.parseColor("#0070ff"));
                    tvHotTag.setBackgroundResource(R.drawable.bg_product_tag1);
                    tvHotTag.setText("今日放水");
                } else {
                    tvHotTag.setVisibility(View.INVISIBLE);
                }

            }

        }
    }

}
