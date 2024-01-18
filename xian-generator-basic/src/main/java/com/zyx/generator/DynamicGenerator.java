package com.zyx.generator;

import com.zyx.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 动态文件生成器
 *
 * @author zyx
 * @version 1.0
 * @date 2024/1/17 017 20:06
 */
public class DynamicGenerator {

    public static void main(String[] args) throws TemplateException, IOException {
        String projectPath = System.getProperty("user.dir") + File.separator + "xian-generator-basic";
        String inputPath = projectPath + File.separator + "src/main/resources/template/MainTemplate.java.ftl";
        String outputPath = projectPath + File.separator + "MainTemplate.java";
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("zyx");
        mainTemplateConfig.setLoop(true);
        mainTemplateConfig.setOutputText("输出结果");
        doGenerate(inputPath, outputPath, mainTemplateConfig);
    }

    /**
     * 生成文件
     *
     * @param inputPath  输入路径
     * @param outputPath 输出路径
     * @param model      模型对象
     * @throws IOException       I/O异常
     * @throws TemplateException 模板异常
     */
    public static void doGenerate(String inputPath, String outputPath, Object model) throws IOException, TemplateException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        File parentFile = new File(inputPath).getParentFile();

        configuration.setDirectoryForTemplateLoading(parentFile);
        configuration.setDefaultEncoding("utf-8");
        configuration.setNumberFormat("0.#####");
        Template template = configuration.getTemplate("MainTemplate.java.ftl");


        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("zyx");
        mainTemplateConfig.setOutputText("输出结果");
        mainTemplateConfig.setLoop(true);

        FileWriter out = new FileWriter(outputPath);
        template.process(model, out);

        out.close();
    }
}
