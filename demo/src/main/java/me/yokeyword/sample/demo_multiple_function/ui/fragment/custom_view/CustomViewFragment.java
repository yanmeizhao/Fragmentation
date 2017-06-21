package me.yokeyword.sample.demo_multiple_function.ui.fragment.custom_view;

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
import me.yokeyword.sample.demo_multiple_function.ui.fragment.custom_view.view.DatePickerDialogFragment;
import me.yokeyword.sample.demo_multiple_function.ui.fragment.design_pattern.ContentFragment;
import me.yokeyword.sample.demo_multiple_function.ui.fragment.design_pattern.MenuListFragment;

/**
 * Copyright (c) 2017-2018 LINKFACE Corporation. All rights reserved
 */

public class CustomViewFragment extends BaseMainFragment {

    private static final String TAG = "DesignPatternsFragment";

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.id_fl_custom_view_list_container)
    FrameLayout mFlCustomDesignViewList;
    @BindView(R.id.id_fl_custom_view_content_container)
    FrameLayout mFlCustomDesignViewContent;

    public static CustomViewFragment newInstance() {
        Bundle args = new Bundle();

        CustomViewFragment fragment = new CustomViewFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_custom_view, container, false);
        ButterKnife.bind(this, view);
        initData(savedInstanceState);
        return view;
    }

    private void initData(Bundle savedInstanceState) {
        mToolbar.setTitle(R.string.str_design_pattern);
        initToolbarNav(mToolbar);

        if(savedInstanceState == null) {
            ArrayList<String> listMenus = new ArrayList<>();
            listMenus.add("DatePickerDialog");
            listMenus.add("ToastDialog");
            listMenus.add("自定义View3");
            listMenus.add("自定义View4");
            listMenus.add("自定义View5");
            listMenus.add("自定义View6");
            listMenus.add("自定义View7");
            listMenus.add("自定义View8");
            listMenus.add("其他");

            MenuListFragment menuListFragment = MenuListFragment.newInstance(listMenus);
            loadRootFragment(R.id.id_fl_custom_view_list_container, menuListFragment);
            replaceLoadRootFragment(R.id.id_fl_custom_view_content_container, DatePickerDialogFragment.newInstance("自定义DatePickerDialog"), false);
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
