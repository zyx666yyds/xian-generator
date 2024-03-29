package com.zyx.generator;

import com.zyx.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;



/**
 * @author zyx
 * @version 1.0
 * @date 2024/1/17 017 20:42
 */
public class MainGenerator {

    static String myPath = "src/main/resources/template/MainTemplate.java.ftl";

    public static void main(String[] args) throws TemplateException, IOException {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("zyx");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("输出结果");
        doGenerate(mainTemplateConfig);
    }

    /**
     * 生成
     *
     * @param model 数据模型
     * @throws TemplateException
     * @throws IOException
     */
    public static void doGenerate(Object model) throws TemplateException, IOException {

        String inputRootPath = "D:\\IdeaProjects\\xian-generator\\xian-generator-demo-projects\\acm-template-pro";
        String outputRootPath = "D:\\IdeaProjects\\xian-generator";

        String inputPath;
        String outputPath;

        inputPath = new File(inputRootPath,"src/com/zyx/acm/MainTemplate.java.ftl").getAbsolutePath();
        outputPath = new File(outputRootPath,"src/com/zyx/acm/MainTemplate.java").getAbsolutePath();
        DynamicGenerator.doGenerate(inputPath, outputPath, model);

        inputPath = new File(inputRootPath,".gitignore").getAbsolutePath();
        outputPath = new File(outputRootPath,".gitignore").getAbsolutePath();

        StaticGenerator.copyFilesByRecursive(inputPath,outputPath);

        inputPath = new File(inputRootPath,"README.md").getAbsolutePath();
        outputPath = new File(inputRootPath,"README.md").getAbsolutePath();

        StaticGenerator.copyFilesByHutool(inputPath,outputPath);

    }
}
