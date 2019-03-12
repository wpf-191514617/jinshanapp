package com.jinshan.application.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jinshan.application.Constant;
import com.jinshan.application.MyApplication;
import com.jinshan.application.R;
import com.jinshan.application.base.BaseFragment;
import com.jinshan.application.entity.RecommandEntity;
import com.jinshan.application.entity.RecommandResponse;
import com.jinshan.application.http.ProductProvider;
import com.jinshan.application.ui.SearchActivity;
import com.jinshan.application.util.UserDialog;
import com.minilive.library.BaseAdapterUtil;
import com.minilive.library.entity.EventData;
import com.minilive.library.http.callback.OnJsonCallBack;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class ProductFragment extends BaseFragment {
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.vpList)
    ViewPager vpList;
    Unbinder unbinder;
    @BindView(R.id.layoutSearch)
    LinearLayout layoutSearch;
    @BindView(R.id.tvTitle)
    TextView tvTitle;

    private RecommandResponse mRecommandResponse;

    private int productId;
    private UserDialog mUserDialog;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_product;
    }

    @Override
    protected void initViewAndData() {
        vpList.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if (mRecommandResponse == null){
                    return;
                }
                if (!BaseAdapterUtil.isListNotEmpty(mRecommandResponse.getRecommendList())){
                    return;
                }
                String name = mRecommandResponse.getRecommendList().get(i).getName();
                tvTitle.setText(name);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        ProductProvider.getList(this, new OnJsonCallBack<RecommandResponse>() {
            @Override
            public void onResult(RecommandResponse data) {
                if (data != null) {
                    mRecommandResponse = data;
                    setData(data);
                    String name = mRecommandResponse.getRecommendList().get(0).getName();
                    tvTitle.setText(name);
                }
            }
        });



    }

    private void setData(RecommandResponse data) {
        vpList.setOffscreenPageLimit(data.getRecommendList().size());
        vpList.setAdapter(new PagerAdapter(getChildFragmentManager(), data.getRecommendList()));
        tabLayout.setupWithViewPager(vpList);
        if (MyApplication.isEvent) {
            MyApplication.isEvent = false;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    vpList.setCurrentItem(getIndexById());
                }
            }, 300);
        }

    }

    private int getIndexById() {
        for (int i = 0; i < mRecommandResponse.getRecommendList().size(); i++) {
            RecommandEntity recommandEntity = mRecommandResponse.getRecommendList().get(i);
            if (recommandEntity.getId() == productId) {
                return i;
            }
        }
        return 0;
    }


    @Override
    protected boolean isRegisterEventBus() {
        return true;
    }

    @Override
    protected void onEventComming(EventData eventData) {
        super.onEventComming(eventData);
        if (eventData.getCODE() == Constant.CODE_CLASSIFY) {
            productId = (int) eventData.getData();
            if (mRecommandResponse == null) {
                initViewAndData();
            } else {
                vpList.setCurrentItem(getIndexById());
            }
        }
    }

    @OnClick({R.id.layoutSearch, R.id.ivUser})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.layoutSearch:
                jumpTo(SearchActivity.class);
                break;
            case R.id.ivUser:
                if (mUserDialog == null) {
                    mUserDialog = new UserDialog(getActivity());
                }
                mUserDialog.show();
                break;
        }

    }

    class PagerAdapter extends FragmentStatePagerAdapter {

        private List<RecommandEntity> entities;

        public PagerAdapter(FragmentManager fm, List<RecommandEntity> entityList) {
            super(fm);
            this.entities = entityList;
        }

        @Override
        public Fragment getItem(int i) {
            return new ProductListFragment(entities.get(i));
        }

        @Override
        public int getCount() {
            return entities != null ? entities.size() : 0;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return entities != null ? entities.get(position).getName() : "";
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
}
