package me.yokeyword.sample.demo_multiple_function.ui.fragment.design_pattern;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportFragment;
import me.yokeyword.sample.R;
import me.yokeyword.sample.demo_multiple_function.base.BaseMainFragment;

/**
 * Created by zhym on 30/05/2017.
 */

public class DesignPatternsFragment extends BaseMainFragment{
    private static final String TAG = "DesignPatternsFragment";

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.id_fl_design_patterns_list_container)
    FrameLayout mFlDesignPatternsList;
    @BindView(R.id.id_fl_design_patterns_content_container)
    FrameLayout mFlDesignPatternsContent;


    public static DesignPatternsFragment newInstance() {
        Bundle args = new Bundle();

        DesignPatternsFragment fragment = new DesignPatternsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_design_patterns, container, false);
        ButterKnife.bind(this, view);
        initData(savedInstanceState);
        return view;
    }

    private void initData(Bundle savedInstanceState) {
        mToolbar.setTitle(R.string.str_design_pattern);
        initToolbarNav(mToolbar);

        if(savedInstanceState == null) {
            ArrayList<String> listMenus = new ArrayList<>();
            listMenus.add("观察者模式");
            listMenus.add("代理模式");
            listMenus.add("桥接模式");
            listMenus.add("组合模式");
            listMenus.add("适配器模式");
            listMenus.add("状态模式");
            listMenus.add("命令模式");
            listMenus.add("模板模式");
            listMenus.add("其他");

            MenuListFragment menuListFragment = MenuListFragment.newInstance(listMenus);
            loadRootFragment(R.id.id_fl_design_patterns_list_container, menuListFragment);
            replaceLoadRootFragment(R.id.id_fl_design_patterns_content_container, ContentFragment.newInstance("观察者模式"), false);
        }
    }

    @Override
    public boolean onBackPressedSupport() {
        // ContentFragment是ShopFragment的栈顶子Fragment,会先调用ContentFragment的onBackPressedSupport方法
        Toast.makeText(_mActivity, "onBackPressedSupport-->返回false,交给上层处理!", Toast.LENGTH_SHORT).show();
        return false;
    }


    /**
     * 替换加载 内容Fragment
     *
     * @param fragment
     */
    public void switchContentFragment(ContentFragment fragment) {
        SupportFragment contentFragment = findChildFragment(ContentFragment.class);
        if (contentFragment != null) {
            contentFragment.replaceFragment(fragment, false);
        }
    }

}
