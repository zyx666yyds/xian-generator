package com.zyx.maker.generator.main;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.util.StrUtil;
import com.zyx.maker.generator.JarGenerator;
import com.zyx.maker.generator.ScriptGenerator;
import com.zyx.maker.generator.file.DynamicFileGenerator;
import com.zyx.maker.meta.Meta;
import com.zyx.maker.meta.MetaManager;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * @author zyx
 * @version 1.0
 * @date 2024/1/19 019 14:37
 */
public class MainGenerator {
    public static void main(String[] args) throws TemplateException, IOException, InterruptedException {
        Meta metaObject = MetaManager.getMetaObject();
        System.out.println(metaObject);

        String projectPath = System.getProperty("user.dir");
        String outputPath = projectPath + File.separator + "generated" + File.separator + metaObject.getName();

        if (!FileUtil.exist(outputPath)) {
            FileUtil.mkdir(outputPath);
        }

        //复制原始模板文件路径复制到生成的代码包中
        String sourceRootPath = metaObject.getFileConfig().getSourceRootPath();
        String sourceCopyDestPath = outputPath + File.separator + ".source";
        FileUtil.copy(sourceRootPath, sourceCopyDestPath, false);

        //读取resources目录
        ClassPathResource classPathResource = new ClassPathResource("");
        String inputResourcePath = classPathResource.getAbsolutePath();

        // Java包的基础路径
        //com.zyx
        String outputBasePackage = metaObject.getBasePackage();
        //com/zyx
        String outputBasePackagePath = StrUtil.join("/", StrUtil.split(outputBasePackage, "."));
        //generated/src/main/java/com/zyx
        String outputBaseJavaPackagePath = outputPath + File.separator + "src/main/java/" + outputBasePackagePath;

        String inputFilePath;
        String outputFilePath;

        inputFilePath = inputResourcePath + File.separator + "template/java/model/DataModel.java.ftl";
        outputFilePath = outputBaseJavaPackagePath + File.separator + "model/DataModel.java";
        DynamicFileGenerator.doGenerate(inputFilePath, outputFilePath, metaObject);

        //cli.command.GenerateCommand
        inputFilePath = inputResourcePath + File.separator + "template/java/cli/command/GenerateCommand.java.ftl";
        outputFilePath = outputBaseJavaPackagePath + "/cli/command/GenerateCommand.java";
        DynamicFileGenerator.doGenerate(inputFilePath, outputFilePath, metaObject);

        //cli.command.ConfigCommand
        inputFilePath = inputResourcePath + File.separator + "template/java/cli/command/ConfigCommand.java.ftl";
        outputFilePath = outputBaseJavaPackagePath + "/cli/command/ConfigCommand.java";
        DynamicFileGenerator.doGenerate(inputFilePath, outputFilePath, metaObject);

        //cli.command.ListCommand
        inputFilePath = inputResourcePath + File.separator + "template/java/cli/command/ListCommand.java.ftl";
        outputFilePath = outputBaseJavaPackagePath + "/cli/command/ListCommand.java";
        DynamicFileGenerator.doGenerate(inputFilePath, outputFilePath, metaObject);

        //cli.CommandExecutor
        inputFilePath = inputResourcePath + File.separator + "template/java/cli/CommandExecutor.java.ftl";
        outputFilePath = outputBaseJavaPackagePath + "/cli/CommandExecutor.java";
        DynamicFileGenerator.doGenerate(inputFilePath, outputFilePath, metaObject);

        //Main
        inputFilePath = inputResourcePath + File.separator + "template/java/Main.java.ftl";
        outputFilePath = outputBaseJavaPackagePath + "/Main.java";
        DynamicFileGenerator.doGenerate(inputFilePath, outputFilePath, metaObject);

        //generator.DynamicGenerator
        inputFilePath = inputResourcePath + File.separator + "template/java/generator/DynamicGenerator.java.ftl";
        outputFilePath = outputBaseJavaPackagePath + "/generator/DynamicGenerator.java";
        DynamicFileGenerator.doGenerate(inputFilePath, outputFilePath, metaObject);

        //generator.MainGenerator
        inputFilePath = inputResourcePath + File.separator + "template/java/generator/MainGenerator.java.ftl";
        outputFilePath = outputBaseJavaPackagePath + "/generator/MainGenerator.java";
        DynamicFileGenerator.doGenerate(inputFilePath, outputFilePath, metaObject);

        //generator.StaticGenerator
        inputFilePath = inputResourcePath + File.separator + "template/java/generator/StaticGenerator.java.ftl";
        outputFilePath = outputBaseJavaPackagePath + "/generator/StaticGenerator.java";
        DynamicFileGenerator.doGenerate(inputFilePath, outputFilePath, metaObject);

        //pom.xml
        inputFilePath = inputResourcePath + File.separator + "template/pom.xml.ftl";
        outputFilePath = outputPath + File.separator + "pom.xml";
        DynamicFileGenerator.doGenerate(inputFilePath, outputFilePath, metaObject);

        //README.md
        inputFilePath = inputResourcePath + File.separator + "template/README.md.ftl";
        outputFilePath = outputPath + File.separator + "README.md";
        DynamicFileGenerator.doGenerate(inputFilePath, outputFilePath, metaObject);

        //jar
        JarGenerator.doGenerate(outputPath);

        //封装脚本
        String shellOutputFilePath = outputPath + File.separator + "generator";
        String jarName = String.format("%s-%s-jar-with-dependencies.jar", metaObject.getName(), metaObject.getVersion());
        String jarPath = "target/" + jarName;
        ScriptGenerator.doGenerate(shellOutputFilePath, jarPath);

        //生成精简版程序（dist）
        String distOutputPath = outputPath + "-dist";
        //拷贝jar包
        String targetAbsolutePath = distOutputPath + File.separator + "target";
        FileUtil.mkdir(targetAbsolutePath);
        String jarAbsolutePath = outputPath + File.separator + jarPath;
        FileUtil.copy(jarAbsolutePath, targetAbsolutePath, true);
        //拷贝脚本文件
        FileUtil.copy(shellOutputFilePath, distOutputPath, true);
        FileUtil.copy(shellOutputFilePath + ".bat", distOutputPath, true);
        //拷贝.source（源模版）
        FileUtil.copy(sourceCopyDestPath, distOutputPath, true);
    }
}
