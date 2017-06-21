package me.yokeyword.sample.demo_multiple_function.command_pattern.ex_uml;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import butterknife.OnClick;
import me.yokeyword.sample.R;

/**
 * Created by zhym on 28/05/2017.
 */

public class CommandPatternUmlActivity extends Activity {
    Receiver receiver;
    Command command;
    Invoker invoker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_design_patterns_command_pattern_uml);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        receiver = new Receiver();
        command = new ConcreteCommand(receiver);
        invoker = new Invoker(command);
    }

    @OnClick(R.id.id_btn_design_patterns_command_pattern_uml)
    void onClickUml() {
        invoker.action();
    }
}
