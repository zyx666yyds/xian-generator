package com.zyx.cli.pattern;

/**
 * @author zyx
 * @version 1.0
 * @date 2024/1/18 018 14:50
 */
public class RemoteControl {

    private Command command;

    public void pressButton() {
        command.execute();
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
