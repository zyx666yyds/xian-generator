package com.zyx.cli.pattern;

/**
 * @author zyx
 * @version 1.0
 * @date 2024/1/18 018 14:46
 */
public class Device {

    private String deviceName;

    public Device(String deviceName) {
        this.deviceName = deviceName;
    }

    public void turnOn() {
        System.out.println(deviceName + "打开设备");
    }

    public void turnOff() {
        System.out.println(deviceName + "关闭设备");
    }
}
