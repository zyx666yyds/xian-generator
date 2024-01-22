package com.zyx.maker;


import com.zyx.maker.cli.CommandExecutor;
import com.zyx.maker.generator.main.MainGenerator;
import freemarker.template.TemplateException;

import java.io.IOException;

/**
 * @author zyx
 * @version 1.0
 * @date 2024/1/18 018 15:52
 */
public class Main {
    public static void main(String[] args) throws TemplateException, IOException, InterruptedException {
        MainGenerator mainGenerator = new MainGenerator();
        mainGenerator.doGenerate();
    }
}
