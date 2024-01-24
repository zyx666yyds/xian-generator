package com.zyx.maker.generator.file;

import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;



/**
 * @author zyx
 * @version 1.0
 * @date 2024/1/17 017 20:42
 */
public class FileGenerator {

    static String myPath = "src/main/resources/template/MainGenerator.java.ftl";

    /**
     * 生成
     *
     * @param model 数据模型
     * @throws TemplateException
     * @throws IOException
     */
    public static void doGenerate(Object model) throws TemplateException, IOException {
        String projectPath = System.getProperty("user.dir");
        // 整个项目的根路径
        File parentFile = new File(projectPath).getParentFile();
        // 输入路径
        String inputPath = new File(parentFile, "xian-generator-demo-projects/acm-template").getAbsolutePath();
        String outputPath = projectPath;
        // 生成静态文件
        StaticFileGenerator.copyFilesByHutool(inputPath, outputPath);
        // 生成动态文件
        String inputDynamicFilePath = projectPath + File.separator + myPath;
        String outputDynamicFilePath = outputPath + File.separator + "acm-template/src/com/zyx/acm/MainTemplate.java";
        DynamicFileGenerator.doGenerate(inputDynamicFilePath, outputDynamicFilePath, model);
    }
}
