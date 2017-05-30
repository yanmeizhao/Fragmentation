package me.yokeyword.sample.demo_design_patterns.command_pattern.ex_tetris;


/**
 * Created by zhym on 30/05/2017.
 */

public class LeftCommand implements Command {
    private TetrisMachine machine;

    public LeftCommand(TetrisMachine machine) {
        this.machine = machine;
    }

    @Override
    public void execute() {
        machine.toLeft();
    }
}
