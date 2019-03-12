package com.jinshan.application.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.jinshan.application.Constant;
import com.jinshan.application.R;
import com.jinshan.application.base.BaseActivity;
import com.jinshan.application.entity.BankListResponse;
import com.jinshan.application.http.HomeProvider;
import com.minilive.library.BaseAdapterUtil;
import com.minilive.library.adapter.BaseViewHolderHelper;
import com.minilive.library.adapter.recycler.BaseRecyclerAdapter;
import com.minilive.library.adapter.recycler.OnRecyclerItemClickListener;
import com.minilive.library.http.callback.OnJsonCallBack;
import com.minilive.library.util.Trace;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BankListActivity extends BaseActivity implements OnRefreshListener, OnLoadMoreListener {
    @BindView(R.id.rvSet)
    RecyclerView rvSet;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;

    private int currentPage =1;

    private BankListAdapter mBankListAdapter;

    @Override
    protected boolean isRegisterEventBus() {
        return false;
    }

    @Override
    protected void initViewAndData() {
        ButterKnife.bind(this);
        setTitle("快速办卡");
        refreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                refreshLayout.autoRefresh();
            }
        }, 300);

        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setOnLoadMoreListener(this);
        rvSet.setLayoutManager(new GridLayoutManager(this , 3));
                mBankListAdapter = new BankListAdapter(rvSet);
                rvSet.setAdapter(mBankListAdapter);

                mBankListAdapter.setOnRVItemClickListener(new OnRecyclerItemClickListener() {
                    @Override
                    public void onItemClick(ViewGroup parent, View itemView, int position) {
                        BankListResponse.ResultListBean.ResultlistBean resultlistBean = mBankListAdapter.getData().get(position);
                        if (resultlistBean != null){
                            Bundle bundle = new Bundle();
                            bundle.putString(WebActivity.KEY_TITLE , resultlistBean.getName());
                            bundle.putString(WebActivity.KEY_WEB , resultlistBean.getAccessPath());
                            jumpTo(WebActivity.class , bundle);
                        }
                    }
                });
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.fragment_list;
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        currentPage++;
        getListData();
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        currentPage = 1;
        refreshLayout.setEnableLoadMore(true);
        getListData();
    }

    private void getListData(){
        HomeProvider.getBankList(this, currentPage, new OnJsonCallBack<BankListResponse>() {
            @Override
            public void onResult(BankListResponse data) {
                refreshLayout.finishRefresh();
                refreshLayout.finishLoadMore();
                if (data !=null && data.getResultList() != null
                && BaseAdapterUtil.isListNotEmpty(data.getResultList().getResultlist())){

                    if (data.getResultList().getResultlist().size() < 20){
                        refreshLayout.setEnableLoadMore(false);
                    }

                    if (currentPage == 1){
                        mBankListAdapter.setData(data.getResultList().getResultlist());
                    } else {
                        mBankListAdapter.addMoreData(data.getResultList().getResultlist());
                    }
                } else {
                    refreshLayout.setEnableLoadMore(true);
                }
            }
        });
    }


    class BankListAdapter extends BaseRecyclerAdapter<BankListResponse.ResultListBean.ResultlistBean>{

        public BankListAdapter(RecyclerView recyclerView) {
            super(recyclerView, R.layout.item_home_bean1);
        }

        @Override
        protected void fillData(BaseViewHolderHelper helper, int position, BankListResponse.ResultListBean.ResultlistBean model) {
            Glide.with(mContext).load(Constant.BASEURL + model.getImageUrl()).into(helper.getImageView(R.id.ivLable));
            helper.setText(R.id.tvName , model.getName());
        }
    }


}
