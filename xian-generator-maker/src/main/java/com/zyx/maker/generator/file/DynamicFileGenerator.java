package com.zyx.maker.generator.file;

import cn.hutool.core.io.FileUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 动态文件生成器
 *
 * @author zyx
 * @version 1.0
 * @date 2024/1/17 017 20:06
 */
public class DynamicFileGenerator {
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
        // 创建模板对象，加载指定模板
        String templateName = new File(inputPath).getName();
        Template template = configuration.getTemplate(templateName);

        // 文件不存在则创建文件和父目录
        if (!FileUtil.exist(outputPath)) {
            FileUtil.touch(outputPath);
        }

        // 生成
        Writer out = new FileWriter(outputPath);
        template.process(model, out);

        // 生成文件后别忘了关闭哦
        out.close();
    }
}
