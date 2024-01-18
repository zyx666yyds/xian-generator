package com.zyx.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Option;
import picocli.CommandLine.Command;

/**
 * @author zyx
 * @version 1.0
 * @date 2024/1/18 018 10:38
 */
@Command(name = "ASCIIArt", version = "ASCIIArt 1.0", mixinStandardHelpOptions = true)
public class ASCIIArt implements Runnable {

    @Option(names = {"-s", "--fontSize"}, description = "设置字体大小")
    int fontSize = 19;

    @Parameters(paramLabel = "<word>", defaultValue = "Hello, picocli", description = "输入想输入的")
    private String[] words = {"Hello", "picocli"};

    @Override
    public void run() {
        System.out.println("fontSize = " + fontSize);
        System.out.println("words = " + String.join(",", words));
    }

    public static void main(String[] args) {
        int exeCode = new CommandLine(new ASCIIArt()).execute(args);
        System.exit(exeCode);
    }
}


