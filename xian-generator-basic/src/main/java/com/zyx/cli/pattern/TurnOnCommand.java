package com.zyx.cli.pattern;

/**
 * @author zyx
 * @version 1.0
 * @date 2024/1/18 018 14:44
 */
public class TurnOnCommand implements Command {

    private Device device;

    public TurnOnCommand(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOn();
    }
}
