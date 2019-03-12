package com.jinshan.application.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.jinshan.application.Constant;
import com.jinshan.application.R;
import com.jinshan.application.base.BaseFragment;
import com.jinshan.application.entity.HomeBean;
import com.jinshan.application.entity.SetResponse;
import com.jinshan.application.http.ProductProvider;
import com.jinshan.application.ui.SearchActivity;
import com.minilive.library.adapter.BaseViewHolderHelper;
import com.minilive.library.adapter.recycler.BaseRecyclerAdapter;
import com.minilive.library.adapter.recycler.OnRecyclerItemClickListener;
import com.minilive.library.entity.EventData;
import com.minilive.library.http.callback.OnJsonCallBack;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.greenrobot.event.EventBus;

public class HomeFragment extends BaseFragment implements OnRefreshListener {
    @BindView(R.id.rvSet)
    RecyclerView rvSet;
    Unbinder unbinder;
    @BindView(R.id.layoutSearch)
    LinearLayout layoutSearch;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;

    private ClassifyAdapter classifyAdapter;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_set;
    }

    @Override
    protected void initViewAndData() {
        rvSet.setLayoutManager(new LinearLayoutManager(getActivity()));
        classifyAdapter = new ClassifyAdapter(rvSet);
        rvSet.setAdapter(classifyAdapter);
        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setEnableLoadMore(false);
        refreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                getData();
            }
        }, 300);
    }

    private void getData() {
        ProductProvider.getClassify(this, new OnJsonCallBack<SetResponse>() {
            @Override
            public void onResult(SetResponse data) {
                refreshLayout.finishRefresh();
                if (data != null) {
                    List<SetResponse.ResultBean> resultBeans = data.getResult();
                    List<HomeBean> homeBeans = new ArrayList<>();
                    for (SetResponse.ResultBean resultBean : resultBeans) {
                        HomeBean homeBean = new HomeBean();
                        homeBean.bean = resultBean;
                        homeBean.TAG = 1;
                        homeBeans.add(homeBean);
                    }
                    HomeBean homeBean = new HomeBean();
                    homeBean.TAG = 0;
                    homeBeans.add(0, homeBean);

                    classifyAdapter.setData(homeBeans);

                }
            }

            @Override
            public void onError(String msg) {
                super.onError(msg);
                refreshLayout.finishRefresh();
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

    @OnClick(R.id.layoutSearch)
    public void onViewClicked() {
        jumpTo(SearchActivity.class);
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        getData();
    }

    class ClassifyAdapter extends BaseRecyclerAdapter<HomeBean> {

        public ClassifyAdapter(RecyclerView recyclerView) {
            super(recyclerView);
        }

        @Override
        public int getItemViewType(int position) {
            if (mData.get(position).TAG == 0) {
                return R.layout.item_head;
            }
            return R.layout.item_home;
        }

        @Override
        protected void fillData(BaseViewHolderHelper helper, int position, HomeBean model) {
            if (model.TAG == 0) {
                return;
            }
            final SetResponse.ResultBean bean = model.bean;
            helper.setText(R.id.tvTitle, bean.getClassificationName());
            RecyclerView rvList = helper.getView(R.id.rvList);
            rvList.setFocusable(false);
            rvList.setFocusableInTouchMode(false);
            rvList.setLayoutManager(new GridLayoutManager(getContext(), 4));
            HomeAdapter homeAdapter = new HomeAdapter(rvList);
            rvList.setAdapter(homeAdapter);
            homeAdapter.setData(bean.getResultList());

            homeAdapter.setOnRVItemClickListener(new OnRecyclerItemClickListener() {
                @Override
                public void onItemClick(ViewGroup parent, View itemView, int position) {
                    SetResponse.ResultBean.ResultListBean resultListBean = bean.getResultList().get(position);
                    EventData eventData = new EventData(Constant.CODE_CLASSIFY, resultListBean.getId());
                    EventBus.getDefault().post(eventData);
                    getActivity().finish();
                }
            });

        }
    }


    class HomeAdapter extends BaseRecyclerAdapter<SetResponse.ResultBean.ResultListBean> {

        public HomeAdapter(RecyclerView recyclerView) {
            super(recyclerView, R.layout.item_home_bean);
        }

        @Override
        protected void fillData(BaseViewHolderHelper helper, int position, SetResponse.ResultBean.ResultListBean model) {
            Glide.with(getContext()).load(Constant.BASEURL + model.getImageUrl()).into(helper.getImageView(R.id.ivLable));
            helper.setText(R.id.tvName, model.getName());
        }
    }


}
