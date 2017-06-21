package me.yokeyword.sample.demo_multiple_function;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportActivity;
import me.yokeyword.fragmentation.SupportFragment;
import me.yokeyword.fragmentation.anim.FragmentAnimator;
import me.yokeyword.fragmentation.helper.FragmentLifecycleCallbacks;
import me.yokeyword.sample.R;
import me.yokeyword.sample.demo_multiple_function.base.BaseMainFragment;
import me.yokeyword.sample.demo_multiple_function.ui.fragment.account.LoginFragment;
import me.yokeyword.sample.demo_multiple_function.ui.fragment.custom_view.CustomViewFragment;
import me.yokeyword.sample.demo_multiple_function.ui.fragment.design_pattern.DesignPatternsFragment;

/**
 * Created by zhym on 04/06/2017.
 */

public class MainActivity extends SupportActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        BaseMainFragment.OnFragmentOpenDrawerListener{
    public static final String TAG = SupportActivity.class.getSimpleName();

    // 再点一次退出程序时间设置
    private static final long WAIT_TIME = 2000L;
    private long TOUCH_TIME = 0;

    @BindView(R.id.id_multiple_function_drawer_layout)
    DrawerLayout mDrawer;
    @BindView(R.id.id_mv_multiple_function_container)
    NavigationView mNavigationView;
    @BindView(R.id.id_fl_multiple_function_container)
    FrameLayout mContainer;
//    @BindView(R.id.id_iv_multiple_function_avatar)
    ImageView mIvAvatar;
//    @BindView(R.id.id_tv_multiple_function_nav_name)
    TextView mTvName;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_function);
        ButterKnife.bind(this);

        if(savedInstanceState == null) {
            loadRootFragment(R.id.id_fl_multiple_function_container, DesignPatternsFragment.newInstance());
        }

        initView();

        registerFragmentLifecycleCallbacks(new FragmentLifecycleCallbacks() {
            // 可以监听该Activity下的所有Fragment的18个 生命周期方法

            @Override
            public void onFragmentCreated(SupportFragment fragment, Bundle savedInstanceState) {
                Log.i("MainActivity", "onFragmentCreated--->" + fragment.getClass().getSimpleName());
            }
        });
    }

    private void initView() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        mDrawer.addDrawerListener(toggle);   TODO:test
        toggle.syncState();

        mNavigationView.setNavigationItemSelectedListener(this);
        mNavigationView.setCheckedItem(R.id.id_multiple_function_design_patterns);

        LinearLayout llNavHeader = (LinearLayout) mNavigationView.getHeaderView(0);
        mTvName = (TextView) llNavHeader.findViewById(R.id.id_tv_multiple_function_nav_name);
        mIvAvatar = (ImageView) llNavHeader.findViewById(R.id.id_iv_multiple_function_avatar);

        mNavigationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawer.closeDrawer(GravityCompat.START);

                mDrawer.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        goLogin();
                    }
                }, 250);
            }
        });
    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        // 设置默认Fragment动画  默认竖向(和安卓5.0以上的动画相同)
        return super.onCreateFragmentAnimator();
        // 设置横向(和安卓4.x动画相同)
//        return new DefaultHorizontalAnimator();
        // 设置自定义动画
//        return new FragmentAnimator(enter,exit,popEnter,popExit);
    }

    @Override
    public boolean onNavigationItemSelected(final MenuItem item) {
        mDrawer.closeDrawer(GravityCompat.START);

        mDrawer.postDelayed(new Runnable() {
            @Override
            public void run() {
                int id = item.getItemId();

                SupportFragment topFragment = getTopFragment();

                switch (id) {
                    case R.id.id_multiple_function_design_patterns:
                        DesignPatternsFragment designPatternsFragment = findFragment(DesignPatternsFragment.class);
                        Bundle newBundle = new Bundle();
                        newBundle.putString("from", "主页是设计模式-->来自:" + topFragment.getClass().getSimpleName());
                        designPatternsFragment.putNewBundle(newBundle);

                        start(designPatternsFragment, SupportFragment.SINGLETASK);
                        break;
                    case R.id.id_multiple_function_custom_view:
                        CustomViewFragment customViewFragment = findFragment(CustomViewFragment.class);
                        if(customViewFragment == null) {
                            popTo(DesignPatternsFragment.class, false, new Runnable() {
                                @Override
                                public void run() {
                                    start(CustomViewFragment.newInstance());
                                }
                            });
                        } else {
                            // 如果已经在栈内,则以SingleTask模式start
                            start(customViewFragment, SupportFragment.SINGLETASK);
                        }
//                        DiscoverFragment fragment = findFragment(DiscoverFragment.class);
//                        if (fragment == null) {
//                            popTo(HomeFragment.class, false, new Runnable() {
//                                @Override
//                                public void run() {
//                                    start(DiscoverFragment.newInstance());
//                                }
//                            });
//                        } else {
//                            // 如果已经在栈内,则以SingleTask模式start
//                            start(fragment, SupportFragment.SINGLETASK);
//                        }
                        break;
                    case R.id.id_multiple_function_custom_anim:
                        break;
                    case R.id.id_multiple_function_custom_opengl:
                        break;

                }
            }
        }, 250);
        return true;
    }

    @Override
    public void onOpenDrawer() {
        if (!mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.openDrawer(GravityCompat.START);
        }
    }

    @Override
    public void onBackPressedSupport() {
        if(mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START);
        } else {
            Fragment topFragment = getTopFragment();

            // 主页的Fragment
            if (topFragment instanceof BaseMainFragment) {
                mNavigationView.setCheckedItem(R.id.id_multiple_function_design_patterns);
            }

            if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
                pop();
            } else {
                if (System.currentTimeMillis() - TOUCH_TIME < WAIT_TIME) {
                    finish();
                } else {
                    TOUCH_TIME = System.currentTimeMillis();
                    Toast.makeText(this, R.string.press_again_exit, Toast.LENGTH_SHORT).show();
                }
            }
        }

    }

    private void goLogin() {
        start(LoginFragment.newInstance());
    }
}
