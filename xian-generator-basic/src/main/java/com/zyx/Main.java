package com.zyx;


import com.zyx.cli.CommandExecutor;

/**
 * @author zyx
 * @version 1.0
 * @date 2024/1/18 018 15:52
 */
public class Main {
    public static void main(String[] args) {
        args = new String[]{"generate", "-l", "-a", "-o"};
//        args = new String[]{"config"};
//        args = new String[]{"list"};
        CommandExecutor commandExecutor = new CommandExecutor();
        commandExecutor.doExecute(args);
    }
}
