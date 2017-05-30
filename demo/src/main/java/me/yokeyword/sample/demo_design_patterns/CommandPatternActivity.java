package me.yokeyword.sample.demo_design_patterns;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import butterknife.OnClick;
import me.yokeyword.fragmentation.SupportActivity;
import me.yokeyword.sample.R;
import me.yokeyword.sample.demo_design_patterns.command_pattern.ex_draw.CommandPatternDrawActivity;
import me.yokeyword.sample.demo_design_patterns.command_pattern.ex_tetris.CommandPatternTetrisActivity;
import me.yokeyword.sample.demo_design_patterns.command_pattern.ex_uml.CommandPatternUmlActivity;
import me.yokeyword.sample.demo_design_patterns.ui.fragment.CommandPatternDrawFragment;
import me.yokeyword.sample.demo_design_patterns.ui.fragment.CommandPatternTetrisFragment;

/**
 * Created by zhym on 28/05/2017.
 */

public class CommandPatternActivity extends SupportActivity {

    CommandPatternDrawFragment mDrawFragment;
    CommandPatternTetrisFragment mTetrisFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_design_patterns);
        ButterKnife.bind(this);

        // TODO 转为Fragment专用
//        if (savedInstanceState == null) {
//            loadRootFragment(R.id.fl_container, HomeFragment.newInstance());
//        }
        initView();
    }

    private void initView() {
        mDrawFragment = new CommandPatternDrawFragment();
    }

    @OnClick(R.id.id_design_patterns_command_pattern_draw)
    void onClickDraw() {
        startActivity(new Intent(CommandPatternActivity.this, CommandPatternDrawActivity.class));
//        start(mDrawFragment);
    }

    @OnClick(R.id.id_design_patterns_command_pattern_tetris)
    void onClickTetris() {
        startActivity(new Intent(CommandPatternActivity.this, CommandPatternTetrisActivity.class));
//        start(new CommandPatternTetrisFragment());
    }

    @OnClick(R.id.id_design_patterns_command_pattern_uml)
    void onClickUml() {
        startActivity(new Intent(CommandPatternActivity.this, CommandPatternUmlActivity.class));
//        start(new CommandPatternUmlFragment());
    }

}
