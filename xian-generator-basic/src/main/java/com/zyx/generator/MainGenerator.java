package com.zyx.generator;

import com.zyx.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

import static com.zyx.generator.DynamicGenerator.doGenerate;

/**
 * @author zyx
 * @version 1.0
 * @date 2024/1/17 017 20:42
 */
public class MainGenerator {
    public static void main(String[] args) throws TemplateException, IOException {

        //静态
        String projectPath = System.getProperty("user.dir");
        String inputPath = projectPath + File.separator + "xian-generator-demo-projects" + File.separator + "acm-template";
        String outputPath = projectPath;

        StaticGenerator.copyFilesByRecursive(inputPath, outputPath);

        //动态
        String dynamicInputPath = projectPath + File.separator + "xian-generator-basic/src/main/resources/template/MainTemplate.java.ftl";
        String dynamicOutputPath = projectPath + File.separator + "acm-template/src/com/zyx/acm/MainTemplate.java";
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("zyx");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("输出结果");
        doGenerate(dynamicInputPath, dynamicOutputPath, mainTemplateConfig);
    }
}
