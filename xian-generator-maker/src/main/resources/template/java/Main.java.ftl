package ${basePackage};


import ${basePackage}.cli.CommandExecutor;

/**
 * @author zyx
 * @version 1.0
 * @date 2024/1/18 018 15:52
 */
public class Main {
    public static void main(String[] args) {
        CommandExecutor commandExecutor = new CommandExecutor();
        commandExecutor.doExecute(args);
    }
}
