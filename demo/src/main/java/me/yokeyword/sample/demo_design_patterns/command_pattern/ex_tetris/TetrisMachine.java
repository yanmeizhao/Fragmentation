package me.yokeyword.sample.demo_design_patterns.command_pattern.ex_tetris;

import android.util.Log;
import android.widget.Toast;

/**
 * 接受者（执行具体的代码逻辑）
 * Created by zhym on 30/05/2017.
 */

public class TetrisMachine {
    public void toLeft() {
        Log.i("zhym", "向左");
    }

    public void toRight() {
        Log.i("zhym", "向右");
    }

    public void fastToBottom() {
        Log.i("zhym", "快速落下");
    }

    public void transform() {
        Log.i("zhym", "改变形状");
    }
}
