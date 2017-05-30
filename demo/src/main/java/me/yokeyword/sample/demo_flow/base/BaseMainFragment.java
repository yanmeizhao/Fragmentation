package me.yokeyword.sample.demo_flow.base;

import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.view.View;

import me.yokeyword.fragmentation.anim.FragmentAnimator;
import me.yokeyword.sample.R;


/**
 * Created by YoKeyword on 16/2/3.
 */
public class BaseMainFragment extends BaseFragment {

    protected OnFragmentOpenDrawerListener mOpenDraweListener;

    protected void initToolbarNav(Toolbar toolbar) {
        initToolbarNav(toolbar, false);
    }

    /**
     * 初始化工具导航栏的icon及其点击监听（是否触发侧滑菜单）
     * */
    protected void initToolbarNav(Toolbar toolbar, boolean isHome) {
        toolbar.setNavigationIcon(R.drawable.ic_menu_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOpenDraweListener != null) {
                    mOpenDraweListener.onOpenDrawer();
                }
            }
        });
    }


    /**
     * Fragment切换动画
     * */
    @Override
    protected FragmentAnimator onCreateFragmentAnimator() {
        FragmentAnimator fragmentAnimator = _mActivity.getFragmentAnimator();
        fragmentAnimator.setEnter(0);
        fragmentAnimator.setExit(0);
        return fragmentAnimator;
    }

    /**
     * 将侧滑菜单监听与当前Fragment所在的上下文context绑定
     * */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentOpenDrawerListener) {
            mOpenDraweListener = (OnFragmentOpenDrawerListener) context;
        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentOpenDrawerListener");
        }
    }

    /**
     * 将策划菜单监听与当前Fragment所在的上下文context解绑
     * */
    @Override
    public void onDetach() {
        super.onDetach();
        mOpenDraweListener = null;
    }

    /**
     * 监听侧滑菜单是否打开
     * */
    public interface OnFragmentOpenDrawerListener {
        void onOpenDrawer();
    }
}
