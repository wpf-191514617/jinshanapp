package com.jinshan.application.ui;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jinshan.application.Constant;
import com.jinshan.application.MyApplication;
import com.jinshan.application.R;
import com.jinshan.application.entity.AppBean;
import com.jinshan.application.http.UserProvider;
import com.jinshan.application.ui.fragment.HomeFragment;
import com.jinshan.application.ui.fragment.HomeFragment1;
import com.jinshan.application.ui.fragment.MineFragment;
import com.jinshan.application.ui.fragment.ProductFragment;
import com.jinshan.application.ui.fragment.StudyFragment;
import com.minilive.library.entity.EventData;
import com.minilive.library.http.callback.OnJsonCallBack;
import com.minilive.library.util.BaseAppManager;
import com.minilive.library.view.MainNavigateTabBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import me.jessyan.autosize.internal.CustomAdapt;

public class HomeActivity extends AppCompatActivity implements CustomAdapt {

    @BindView(R.id.main_container)
    FrameLayout mainContainer;
    @BindView(R.id.navigateTabBar)
    MainNavigateTabBar navigateTabBar;
    private long mExitTime = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        BaseAppManager.getInstance().addActivity(this);
        navigateTabBar.onRestoreInstanceState(savedInstanceState);

        navigateTabBar.addTab(HomeFragment1.class, new MainNavigateTabBar.TabParam(R.drawable
                .nav_home, R.drawable.nav_home_pre, R.string.tab_home));

        navigateTabBar.addTab(StudyFragment.class, new MainNavigateTabBar.TabParam(R.drawable
                .nav_study, R.drawable.nav_study_pre, R.string.study));

        navigateTabBar.addTab(ProductFragment.class, new MainNavigateTabBar.TabParam(R.drawable
                .nav_loan, R.drawable.nav_loan_pre, R.string.loan));

        navigateTabBar.addTab(MineFragment.class, new MainNavigateTabBar.TabParam(R.drawable
                .nav_per, R.drawable.nav_per_pre, R.string.mine));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //super.onSaveInstanceState(outState);
        //保存当前选中的选项状态
        super.onSaveInstanceState(outState);
        navigateTabBar.onSaveInstanceState(outState);
    }




    @Override
    public boolean isBaseOnWidth() {
        return false;
    }

    @Override
    public float getSizeInDp() {
        return 640;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Subscribe
    public void onEventMainThread(EventData data) {
        if (null != data) {
            if (data.getCODE() == Constant.CODE_CLASSIFY||
                    data.getCODE() == Constant.CODE_CLASSIFY1){
                MyApplication.isEvent = true;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                navigateTabBar.setCurrentSelectedTab(2);
                            }
                        });

                    }
                },300);

            } else if (data.getCODE() == Constant.CODE_LOAN){
                navigateTabBar.setCurrentSelectedTab(2);
            }
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //判断用户是否点击了“返回键”
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //与上次点击返回键时刻作差
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                //大于2000ms则认为是误操作，使用Toast进行提示
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                //并记录下本次点击“返回键”的时刻，以便下次进行判断
                mExitTime = System.currentTimeMillis();
            } else {
                //小于2000ms则认为是用户确实希望退出程序-调用System.exit()方法进行退出
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
