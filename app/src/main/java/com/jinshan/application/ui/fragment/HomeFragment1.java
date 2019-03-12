package com.jinshan.application.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.jinshan.application.Constant;
import com.jinshan.application.R;
import com.jinshan.application.base.BaseFragment;
import com.jinshan.application.entity.BannerResponse;
import com.jinshan.application.entity.HomeBean;
import com.jinshan.application.entity.HomeEntity;
import com.jinshan.application.entity.HomeLoanBean;
import com.jinshan.application.entity.PostListResponse;
import com.jinshan.application.entity.ProductEntity;
import com.jinshan.application.http.HomeProvider;
import com.jinshan.application.ui.AboutUSActivity;
import com.jinshan.application.ui.BankListActivity;
import com.jinshan.application.ui.ProductDetailActivity;
import com.jinshan.application.ui.SearchActivity;
import com.jinshan.application.ui.SetActivity;
import com.jinshan.application.ui.WebActivity;
import com.jinshan.application.util.GlideRoundTransform;
import com.minilive.library.BaseAdapterUtil;
import com.minilive.library.adapter.BaseViewHolderHelper;
import com.minilive.library.adapter.recycler.BaseRecyclerAdapter;
import com.minilive.library.adapter.recycler.OnRecyclerItemClickListener;
import com.minilive.library.entity.EventData;
import com.minilive.library.http.callback.OnJsonCallBack;
import com.minilive.library.util.TimeUtil;
import com.minilive.library.util.Trace;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.greenrobot.event.EventBus;

public class HomeFragment1 extends BaseFragment implements OnRefreshListener, OnLoadMoreListener {

    @BindView(R.id.rlSearch)
    RelativeLayout rlSearch;
    @BindView(R.id.rvSet)
    RecyclerView rvSet;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    Unbinder unbinder;
    private HomeLoanBean mHomeLoanBean;
    private BannerResponse mBannerResponse;
    private int mCurrentPage = 1;

    private HomeLisAdapter homeLisAdapter;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initViewAndData() {
        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setOnLoadMoreListener(this);
        refreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                onRefresh(refreshLayout);
            }
        }, 300);

        rvSet.setLayoutManager(new LinearLayoutManager(getContext()));
        homeLisAdapter = new HomeLisAdapter(rvSet);
        rvSet.setAdapter(homeLisAdapter);
    }


    private void loadBannerData(){
        HomeProvider.getBannerData(this, "首页", new OnJsonCallBack<BannerResponse>() {
            @Override
            public void onResult(BannerResponse data) {
                mBannerResponse = data;
                loadLoanData();
            }

            @Override
            public void onError(String msg) {
                super.onError(msg);
                loadLoanData();
            }
        });
    }


    private void loadLoanData() {
        HomeProvider.getHomeLoanData(this, new OnJsonCallBack<HomeLoanBean>() {
            @Override
            public void onResult(HomeLoanBean data) {
                if (data != null) {
                    mHomeLoanBean = data;
                }
                loadPostList();
            }

            @Override
            public void onError(String msg) {
                super.onError(msg);
                loadPostList();
            }
        });
    }

    private void loadPostList() {
        HomeProvider.getHomePostData(this, mCurrentPage, new OnJsonCallBack<PostListResponse>() {
            @Override
            public void onResult(PostListResponse data) {
                refreshLayout.finishRefresh();
                refreshLayout.finishLoadMore();
                if (data == null){
                    return;
                }

                List<HomeEntity> homeBeanList = new ArrayList<>();
                if (mCurrentPage == 1){
                    HomeEntity homeBean = new HomeEntity();
                    homeBean.TAG = 0;
                    homeBean.bean = mBannerResponse;
                    homeBeanList.add(homeBean);

                    homeBean = new HomeEntity();
                    homeBean.TAG =1;
                    homeBean.bean = mHomeLoanBean;
                    homeBeanList.add(homeBean);

                }

                if (data != null && data.getPage() != null && BaseAdapterUtil.isListNotEmpty(data.getPage().getResultlist())){
                    for (PostListResponse.PageBean.ResultlistBean resultlistBean : data.getPage().getResultlist()){
                        HomeEntity homeEntity = new HomeEntity();
                        homeEntity.TAG = 2;
                        homeEntity.bean = resultlistBean;
                        homeBeanList.add(homeEntity);
                    }
                }

                if (BaseAdapterUtil.isListNotEmpty(homeBeanList)){
                    if (mCurrentPage == 1){
                        homeLisAdapter.setData(homeBeanList);
                    } else {
                        homeLisAdapter.addMoreData(homeBeanList);
                    }
                } else{
                    refreshLayout.setEnableLoadMore(false);
                }


            }

            @Override
            public void onError(String msg) {
                super.onError(msg);
            }
        });
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        mCurrentPage++;
        loadPostList();
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        mCurrentPage =1;
        refreshLayout.setEnableLoadMore(true);
        loadBannerData();
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

    @OnClick(R.id.rlSearch)
    public void onViewClicked() {
        jumpTo(SearchActivity.class);
    }


    class HomeLisAdapter extends BaseRecyclerAdapter<HomeEntity> {

        public HomeLisAdapter(RecyclerView recyclerView) {
            super(recyclerView);
        }


        @Override
        public int getItemViewType(int position) {
            if (mData.get(position).TAG == 0) {
                return R.layout.item_banner;
            } else if (mData.get(position).TAG == 1) {
                return R.layout.item_home_loan;
            }
            return R.layout.item_home_post;
        }

        @Override
        protected void fillData(BaseViewHolderHelper helper, int position, HomeEntity model) {
            switch (model.TAG){
                case 0:
                    mBannerResponse = (BannerResponse) model.bean;
                    setBannerData(helper,mBannerResponse);
                    break;
                case 1:
                    RecyclerView recyclerView = helper.getView(R.id.rvList);
                    recyclerView.setLayoutManager(new LinearLayoutManager(mContext , LinearLayoutManager.HORIZONTAL , false));
                    final HomeLoanAdapter homeLoanAdapter = new HomeLoanAdapter(recyclerView);
                    recyclerView.setAdapter(homeLoanAdapter);
                    mHomeLoanBean = (HomeLoanBean) model.bean;
                    homeLoanAdapter.setData(mHomeLoanBean.getRecommendLoanCrackList());

                    homeLoanAdapter.setOnRVItemClickListener(new OnRecyclerItemClickListener() {
                        @Override
                        public void onItemClick(ViewGroup parent, View itemView, int position) {
                            ProductEntity entity = homeLoanAdapter.getItem(position);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("data" , entity);
                            jumpTo(ProductDetailActivity.class,bundle);
                        }
                    });

                    break;
                case 2:
                    final PostListResponse.PageBean.ResultlistBean resultlistBean = (PostListResponse.PageBean.ResultlistBean) model.bean;
                    helper.setText(R.id.tvPost , resultlistBean.getTitle())
                           // .setText(R.id.tvPostTime , String.valueOf(resultlistBean.getCreateTime()))
                            .setText(R.id.tvPostTime ,"")
                            .setText(R.id.tvPostCount , String.valueOf(resultlistBean.getLikeNum()));

                    Glide.with(mContext).load(Constant.BASEURL + resultlistBean.getCoverImage())
                            .into(helper.getImageView(R.id.ivPost));


                    helper.getView(R.id.layoutPostContent).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Bundle bundle = new Bundle();
                            bundle.putString(WebActivity.KEY_TITLE , resultlistBean.getTitle());
                            bundle.putString(WebActivity.KEY_WEB , String.valueOf(resultlistBean.getId()));
                            bundle.putBoolean(WebActivity.KEY_POSTDETAIL , true);
                            jumpTo(WebActivity.class , bundle);
                        }
                    });

                    break;
            }
        }
    }

    private void setBannerData(BaseViewHolderHelper helper, final BannerResponse mBannerResponse) {

        XBanner xBanner = helper.getView(R.id.banner);
        xBanner.setAutoPlayAble(mBannerResponse.getAdvertisementList().size() > 1);
        xBanner.setIsClipChildrenMode(true);
        //老方法，不推荐使用
        xBanner.setData(R.layout.layout_image, mBannerResponse.getAdvertisementList(), null);
        xBanner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                RequestOptions myOptions = new RequestOptions()
                        .transform(new GlideRoundTransform(getActivity(),8));

                ImageView view1 = (ImageView) view;
                BannerResponse.AdvertisementListBean listBean = mBannerResponse.getAdvertisementList().get(position);
                Glide.with(getActivity()).load(Constant.BASEURL + listBean.getCoverImageUrl())
                        .apply(myOptions).into(view1);
            }
        });

        xBanner.setOnItemClickListener(new XBanner.OnItemClickListener() {
            @Override
            public void onItemClick(XBanner banner, Object model, View view, int position) {
                BannerResponse.AdvertisementListBean listBean = mBannerResponse.getAdvertisementList().get(position);
                Bundle bundle = new Bundle();
                bundle.putString(WebActivity.KEY_TITLE , listBean.getTitle());
                bundle.putString(WebActivity.KEY_WEB , listBean.getOperateSrc());
                jumpTo(WebActivity.class , bundle);
            }
        });

        helper.getView(R.id.layoutLoan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventData eventData = new EventData(Constant.CODE_LOAN);
                EventBus.getDefault().post(eventData);
            }
        });

        helper.getView(R.id.layoutBank).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpTo(BankListActivity.class);
            }
        });

        helper.getView(R.id.layoutMember).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpTo(AboutUSActivity.class);
            }
        });

        helper.getView(R.id.layoutSummary).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpTo(SetActivity.class);
            }
        });

    }


    class HomeLoanAdapter extends BaseRecyclerAdapter<ProductEntity>{

        public HomeLoanAdapter(RecyclerView recyclerView) {
            super(recyclerView, R.layout.item_loan);
        }

        @Override
        protected void fillData(BaseViewHolderHelper helper, int position, ProductEntity model) {
            helper.setText(R.id.tvLoanName , model.getName());
            Glide.with(mContext).load(Constant.BASEURL + model.getImageUrl()).into(helper.getImageView(R.id.civLoan));
        }
    }
}
