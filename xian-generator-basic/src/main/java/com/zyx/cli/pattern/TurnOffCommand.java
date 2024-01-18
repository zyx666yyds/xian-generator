package com.zyx.cli.pattern;

/**
 * @author zyx
 * @version 1.0
 * @date 2024/1/18 018 14:43
 */
public class TurnOffCommand implements Command {

    private Device device;

    public TurnOffCommand(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOff();
    }
}
