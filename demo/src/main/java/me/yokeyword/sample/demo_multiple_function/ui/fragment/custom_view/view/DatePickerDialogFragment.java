package me.yokeyword.sample.demo_multiple_function.ui.fragment.custom_view.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.yokeyword.fragmentation.SupportFragment;
import me.yokeyword.fragmentation.anim.DefaultNoAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;
import me.yokeyword.sample.R;
import me.yokeyword.sample.demo_flow.ui.fragment.CycleFragment;
import me.yokeyword.sample.demo_flow.ui.fragment.shop.ShopFragment;
import me.yokeyword.sample.demo_multiple_function.base.BaseMainFragment;
import me.yokeyword.sample.demo_multiple_function.ui.fragment.custom_view.CustomViewFragment;
import me.yokeyword.sample.demo_multiple_function.ui.fragment.design_pattern.ContentFragment;

/**
 * 自定义日期选择View（人证一体机 日期选择 查询）
 */

public class DatePickerDialogFragment extends BaseMainFragment {
    private static final String ARG_MENU = "arg_menu";

    private String mMenu;

    public static DatePickerDialogFragment newInstance(String menu) {

        Bundle args = new Bundle();
        args.putString(ARG_MENU, menu);

        DatePickerDialogFragment fragment = new DatePickerDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        if (args != null) {
            mMenu = args.getString(ARG_MENU);
        }
    }

    @Override
    protected FragmentAnimator onCreateFragmentAnimator() {
        return new DefaultNoAnimator();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_custom_view_date_picker_dialog, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @OnClick(R.id.id_tv_custom_date_picker_dialog)
    void activeDatePickDialog() {
        // 和MsgFragment同级别的跳转 交给MsgFragment处理
//        if (getParentFragment() instanceof CustomViewFragment) {
//            ((CustomViewFragment) getParentFragment()).start(CycleFragment.newInstance(1));
//        }

        Toast.makeText(getContext(), "弹出dialog", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onBackPressedSupport() {
        // ContentFragment是ShopFragment的栈顶子Fragment,可以在此处理返回按键事件
        return super.onBackPressedSupport();
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
