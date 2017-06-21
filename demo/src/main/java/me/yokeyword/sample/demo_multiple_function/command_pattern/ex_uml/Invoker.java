package me.yokeyword.sample.demo_multiple_function.command_pattern.ex_uml;

/**
 * Created by zhym on 30/05/2017.
 */

public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action() {
        command.execute();
    }
}
