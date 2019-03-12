package com.jinshan.application.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.jinshan.application.Constant;
import com.jinshan.application.R;
import com.jinshan.application.base.BaseFragment;
import com.jinshan.application.entity.PostListResponse;
import com.jinshan.application.entity.PostResponse;
import com.jinshan.application.http.HomeProvider;
import com.jinshan.application.ui.WebActivity;
import com.minilive.library.BaseAdapterUtil;
import com.minilive.library.adapter.BaseViewHolderHelper;
import com.minilive.library.adapter.recycler.BaseRecyclerAdapter;
import com.minilive.library.http.callback.OnJsonCallBack;
import com.minilive.library.util.StringUtils;
import com.minilive.library.util.TimeUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

@SuppressLint("ValidFragment")
public class PostListFragment extends BaseFragment implements OnRefreshListener , OnLoadMoreListener {

    @BindView(R.id.rvSet)
    RecyclerView rvSet;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    Unbinder unbinder;
    private String id;

    private int currentPage;

    private PostListAdapter mPostListAdapter;

    public PostListFragment(String id) {
        this.id = id;
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.recycler;
    }

    @Override
    protected void initViewAndData() {
        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setOnLoadMoreListener(this);
        rvSet.setLayoutManager(new LinearLayoutManager(getActivity()));
        mPostListAdapter = new PostListAdapter(rvSet);
        rvSet.setAdapter(mPostListAdapter);
        getData();
    }

    private void getData() {
        if (!StringUtils.isEmpty(id)){
            HomeProvider.getPostListById(this, id, currentPage, 10, new OnJsonCallBack<PostResponse>() {
                @Override
                public void onResult(PostResponse data) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                    if (data != null){
                        if (data.getPage() != null && BaseAdapterUtil.isListNotEmpty(data.getPage().getResultlist())){
                            if (currentPage == 1){
                                mPostListAdapter.setData(data.getPage().getResultlist());
                            } else {
                                mPostListAdapter.addMoreData(data.getPage().getResultlist());
                            }
                            if (data.getPage().getResultlist().size() < 10){
                                refreshLayout.setEnableLoadMore(false);
                            }
                        }

                    } else {
                        refreshLayout.setEnableLoadMore(true);
                    }
                }
            });
        }
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
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        currentPage ++;
        getData();
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        currentPage = 1;
        refreshLayout.setEnableLoadMore(true);
        getData();
    }


    class PostListAdapter extends BaseRecyclerAdapter<PostResponse.PageBean.ResultlistBean>{

        public PostListAdapter(RecyclerView recyclerView) {
            super(recyclerView, R.layout.item_home_post);
        }

        @Override
        protected void fillData(BaseViewHolderHelper helper, int position,
                                final PostResponse.PageBean.ResultlistBean model) {


            helper.setText(R.id.tvPost , model.getTitle())
                   // .setText(R.id.tvPostTime , String.valueOf(model.getCreateTime()))
                    .setText(R.id.tvPostTime ,"")
                    .setText(R.id.tvPostCount , String.valueOf(model.getLikeNum()));

            Glide.with(mContext).load(Constant.BASEURL + model.getCoverImage())
                    .into(helper.getImageView(R.id.ivPost));


            helper.getView(R.id.layoutPostContent).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putString(WebActivity.KEY_TITLE , model.getTitle());
                    bundle.putString(WebActivity.KEY_WEB , String.valueOf(model.getId()));
                    bundle.putBoolean(WebActivity.KEY_POSTDETAIL , true);
                    jumpTo(WebActivity.class , bundle);
                }
            });

        }
    }

}
