package me.yokeyword.sample.demo_design_patterns.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.yokeyword.sample.R;
import me.yokeyword.sample.demo_design_patterns.base.BaseFragment;

/**
 * Created by zhym on 28/05/2017.
 */

public class CommandPatternDrawFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_design_patterns_command_pattern_draw, container, false);
//        ButterKnife.bind(getActivity(), view);
        return view;
    }
}
