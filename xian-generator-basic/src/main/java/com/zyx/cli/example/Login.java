package com.zyx.cli.example;

import picocli.CommandLine;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.concurrent.Callable;

/**
 * @author zyx
 * @version 1.0
 * @date 2024/1/18 018 11:28
 */
class Login implements Callable<Integer> {
    @CommandLine.Option(names = {"-u", "--user"}, description = "User name")
    String user;
    @CommandLine.Option(names = {"-p", "--password"}, description = "Passphrase", interactive = true)
    char[] password;

    public Integer call() throws Exception {
        System.out.println("password=" + password);

        return 0;
    }

    public static void main(String[] args) {
        args = new String[]{"-u", "userzyx", "-p"};
        new CommandLine(new Login()).execute(args);
    }
}