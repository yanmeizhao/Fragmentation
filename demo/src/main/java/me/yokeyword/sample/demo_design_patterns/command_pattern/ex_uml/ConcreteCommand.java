package me.yokeyword.sample.demo_design_patterns.command_pattern.ex_uml;

/**
 * Created by zhym on 30/05/2017.
 */

public class ConcreteCommand implements Command {
    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
