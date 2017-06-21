package me.yokeyword.sample.demo_multiple_function.base;

import android.app.Activity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import me.yokeyword.fragmentation.anim.FragmentAnimator;
import me.yokeyword.sample.R;

/**
 * Created by zhym on 30/05/2017.
 */

public class BaseMainFragment extends BaseFragment{

    protected OnFragmentOpenDrawerListener mOpenDrawListener;

    protected void initToolbarNav(Toolbar toolbar) {
        toolbar.setNavigationIcon(R.drawable.ic_menu_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOpenDrawListener != null) {
                    mOpenDrawListener.onOpenDrawer();
                }
            }
        });
    }

    @Override
    protected FragmentAnimator onCreateFragmentAnimator() {
        FragmentAnimator fragmentAnimator = _mActivity.getFragmentAnimator();
        fragmentAnimator.setEnter(0);
        fragmentAnimator.setExit(0);
        return fragmentAnimator;
    }

    /**
     * 监听侧滑菜单是否打开
     * */
    public interface OnFragmentOpenDrawerListener {
        void onOpenDrawer();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof OnFragmentOpenDrawerListener) {
            mOpenDrawListener = (OnFragmentOpenDrawerListener) activity;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mOpenDrawListener = null;
    }
}
