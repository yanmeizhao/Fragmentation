package me.yokeyword.sample.demo_design_patterns.command_pattern.ex_tetris;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.yokeyword.sample.R;

/**
 * Created by zhym on 28/05/2017.
 */

public class CommandPatternTetrisActivity extends Activity {
    TetrisMachine machine = new TetrisMachine();

    LeftCommand leftCommand = new LeftCommand(machine);
    RightCommand rightCommand = new RightCommand(machine);
    FallCommand fallCommand = new FallCommand(machine);
    TransformCommand transformCommand = new TransformCommand(machine);

    CommandInvoker invoker = new CommandInvoker();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_design_patterns_command_pattern_tetris);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        invoker.setLeftCommand(leftCommand);
        invoker.setRightCommand(rightCommand);
        invoker.setFallCommand(fallCommand);
        invoker.setTransformCommand(transformCommand);
    }

    @OnClick(R.id.id_btn_design_patterns_command_pattern_tetris_left)
    void onClickLeft() {
        invoker.toLeft();
    }

    @OnClick(R.id.id_btn_design_patterns_command_pattern_tetris_right)
    void onClickRight() {
        invoker.toRight();
    }

    @OnClick(R.id.id_btn_design_patterns_command_pattern_tetris_fall)
    void onClickFall() {
        invoker.fall();
    }

    @OnClick(R.id.id_btn_design_patterns_command_pattern_tetris_up)
    void onClickTransform() {
        invoker.transform();
    }
}
