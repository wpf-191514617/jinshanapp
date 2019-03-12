package com.jinshan.application.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.jinshan.application.Constant;
import com.jinshan.application.R;
import com.jinshan.application.base.BaseFragment;
import com.jinshan.application.entity.BannerResponse;
import com.jinshan.application.entity.CategoryResponse;
import com.jinshan.application.entity.PostResponse;
import com.jinshan.application.http.HomeProvider;
import com.jinshan.application.ui.WebActivity;
import com.jinshan.application.util.GlideRoundTransform;
import com.minilive.library.BaseAdapterUtil;
import com.minilive.library.adapter.BaseViewHolderHelper;
import com.minilive.library.adapter.recycler.BaseRecyclerAdapter;
import com.minilive.library.adapter.recycler.OnRecyclerItemClickListener;
import com.minilive.library.http.callback.OnJsonCallBack;
import com.minilive.library.util.Trace;
import com.stx.xhb.xbanner.XBanner;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class StudyFragment extends BaseFragment {
    @BindView(R.id.banner)
    XBanner banner;
    @BindView(R.id.rvHot)
    RecyclerView rvHot;
    @BindView(R.id.collapsingToolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    Unbinder unbinder;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_study;
    }

    @Override
    protected void initViewAndData() {
        getBannerData();
        getHotData();
        getCategoryList();
    }

    private void getCategoryList(){
        HomeProvider.getCategotyList(this, new OnJsonCallBack<CategoryResponse>() {
            @Override
            public void onResult(CategoryResponse data) {
                if (data != null){
                    if (BaseAdapterUtil.isListNotEmpty(data.getCategoryPostlist())){
                        PostPageAdapter postPageAdapter = new PostPageAdapter(getChildFragmentManager() , data.getCategoryPostlist());
                        viewpager.setOffscreenPageLimit(data.getCategoryPostlist().size());
                        viewpager.setAdapter(postPageAdapter);
                        tabLayout.setupWithViewPager(viewpager);
                    }
                }
            }
        });
    }

    private void getHotData() {
        HomeProvider.getSelectHotData(this, new OnJsonCallBack<PostResponse>() {
            @Override
            public void onResult(PostResponse data) {
                rvHot.setLayoutManager(new LinearLayoutManager(getActivity() ,LinearLayoutManager.HORIZONTAL , false));
                final HotListAdapter hotListAdapter = new HotListAdapter(rvHot);
                rvHot.setAdapter(hotListAdapter);
                hotListAdapter.setData(data.getPage().getResultlist());
                hotListAdapter.setOnRVItemClickListener(new OnRecyclerItemClickListener() {
                    @Override
                    public void onItemClick(ViewGroup parent, View itemView, int position) {
                        PostResponse.PageBean.ResultlistBean model = hotListAdapter.getItem(position);
                        Bundle bundle = new Bundle();
                        bundle.putString(WebActivity.KEY_TITLE , model.getTitle());
                        bundle.putString(WebActivity.KEY_WEB , String.valueOf(model.getId()));
                        bundle.putBoolean(WebActivity.KEY_POSTDETAIL , true);
                        jumpTo(WebActivity.class , bundle);
                    }
                });
            }
        });
    }

    private void getBannerData() {
        HomeProvider.getBannerData(this, "学习", new OnJsonCallBack<BannerResponse>() {
            @Override
            public void onResult(BannerResponse data) {
                if (data != null){
                    setBannerData(data);
                }
            }
        });
    }

    private void setBannerData(final BannerResponse data) {

        banner.setAutoPlayAble(data.getAdvertisementList().size() > 1);
        //老方法，不推荐使用
       //banner.setData(R.layout.layout_image, data.getAdvertisementList(), null);
        banner.setBannerData(data.getAdvertisementList());
        banner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                ImageView view1 = (ImageView) view;
                BannerResponse.AdvertisementListBean listBean = data.getAdvertisementList().get(position);
                Glide.with(getActivity()).load(Constant.BASEURL + listBean.getCoverImageUrl()).into(view1);
            }
        });

        banner.setOnItemClickListener(new XBanner.OnItemClickListener() {
            @Override
            public void onItemClick(XBanner banner, Object model, View view, int position) {
                BannerResponse.AdvertisementListBean listBean = data.getAdvertisementList().get(position);
                Bundle bundle = new Bundle();
                bundle.putString(WebActivity.KEY_TITLE , listBean.getTitle());
                bundle.putString(WebActivity.KEY_WEB , listBean.getOperateSrc());
                jumpTo(WebActivity.class , bundle);
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


    class HotListAdapter extends BaseRecyclerAdapter<PostResponse.PageBean.ResultlistBean>{

        public HotListAdapter(RecyclerView recyclerView) {
            super(recyclerView, R.layout.item_hot_post);
        }

        @Override
        protected void fillData(BaseViewHolderHelper helper, int position, PostResponse.PageBean.ResultlistBean model) {
            View view = helper.getView(R.id.layoutPost);
            if (position == 0){
                view.setBackgroundResource(R.drawable.study_img_01);
            } else if (position == 1){
                view.setBackgroundResource(R.drawable.study_img_02);
            } else if (position == 2){
                view.setBackgroundResource(R.drawable.study_img_03);
            } else if (position == 3){
                view.setBackgroundResource(R.drawable.study_img_04);
            } else if (position == 4){
                view.setBackgroundResource(R.drawable.study_img_05);
            }
            helper.setText(R.id.tvTitle , model.getTitle());
        }
    }


    class  PostPageAdapter extends FragmentStatePagerAdapter{

        List<CategoryResponse.CategoryPostlistBean> data;

        public PostPageAdapter(FragmentManager fm, List<CategoryResponse.CategoryPostlistBean> data) {
            super(fm);
            this.data = data;
        }

        @Override
        public Fragment getItem(int i) {
            return new PostListFragment(String.valueOf(data.get(i).getId()));
        }

        @Override
        public int getCount() {
            return data.size();
        }


        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return data.get(position).getName();
        }
    }



}
