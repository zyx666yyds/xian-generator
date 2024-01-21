package com.zyx.maker.meta;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author zyx
 * @version 1.0
 * @date 2024/1/21 021 17:19
 */
public class MetaValidator {
    public static void doValidAndFill(Meta meta) {

        validAndFillMetaRoot(meta);

        validAndFillFileConfig(meta);
        validAndFillModelConfig(meta);

        //fileConfig校验和默认值

        //modelConfig校验和默认值
    }

    private static void validAndFillModelConfig(Meta meta) {
        Meta.ModelConfig modelConfig = meta.getModelConfig();
        if (modelConfig == null) {
            return;
        }
        List<Meta.ModelConfig.ModelInfo> models = modelConfig.getModels();
        if (CollUtil.isEmpty(models)) {
            return;
        }
        for (Meta.ModelConfig.ModelInfo model : models) {
            String fieldName = model.getFieldName();
            if (StrUtil.isBlank(fieldName)) {
                throw new MetaException("fieldName 不能为空");
            }

            String type = model.getType();
            if (StrUtil.isEmpty(type)) {
                model.setType("String");
            }
        }
    }

    private static void validAndFillFileConfig(Meta meta) {
        Meta.FileConfig fileConfig = meta.getFileConfig();
        if (fileConfig == null) {
            return;
        }
        String sourceRootPath = fileConfig.getSourceRootPath();
        if (StrUtil.isBlank(sourceRootPath)) {
            throw new MetaException("sourceRootPath 不能为空");
        }

        String inputRootPath = fileConfig.getInputRootPath();
        String defaultInputRootPath = ".source/" + FileUtil.getLastPathEle(Paths.get(sourceRootPath)).getFileName().toString();
        if (StrUtil.isEmpty(inputRootPath)) {
            fileConfig.setInputRootPath(defaultInputRootPath);
        }

        String outputRootPath = fileConfig.getOutputRootPath();
        String defaultOutputRootPath = "generated";
        if (StrUtil.isEmpty(outputRootPath)) {
            fileConfig.setOutputRootPath(defaultOutputRootPath);
        }

        String type = fileConfig.getType();
        String defaultType = "dir";
        if (StrUtil.isEmpty(type)) {
            fileConfig.setType(defaultType);
        }

        List<Meta.FileConfig.FileInfo> files = fileConfig.getFiles();
        if (CollUtil.isEmpty(files)) {
            return;
        }
        for (Meta.FileConfig.FileInfo file : files) {
            //inputPath 必填
            String inputPath = file.getInputPath();
            if (StrUtil.isBlank(inputPath)) {
                throw new MetaException("inputPath 不能为空");
            }

            String outputPath = file.getOutputPath();
            if (StrUtil.isBlank(outputPath)) {
                file.setOutputPath(inputPath);
            }

            String type1 = file.getType();
            if (StrUtil.isBlank(type1)) {
                //无文件后缀
                if (StrUtil.isBlank(FileUtil.getSuffix(inputPath))) {
                    file.setType(defaultType);
                } else {
                    file.setType("file");
                }
            }

            String generateType = file.getGenerateType();
            if (StrUtil.isBlank(generateType)) {
                if (inputPath.endsWith(".ftl")) {
                    file.setGenerateType("dynamic");
                } else {
                    file.setGenerateType("static");
                }
            }
        }

    }

    private static void validAndFillMetaRoot(Meta meta) {
        //基础信息校验
        String name = StrUtil.blankToDefault(meta.getName(), "my-generator");
        String description = StrUtil.blankToDefault(meta.getDescription(), "我的代码生成器");
        String basePackage = StrUtil.blankToDefault(meta.getBasePackage(), "com.zyx");
        String version = StrUtil.blankToDefault(meta.getVersion(), "1.0.0");
        String author = StrUtil.blankToDefault(meta.getAuthor(), "zyx");
        String createTime = StrUtil.blankToDefault(meta.getCreateTime(), DateUtil.now());

        meta.setName(name);
        meta.setDescription(description);
        meta.setBasePackage(basePackage);
        meta.setVersion(version);
        meta.setAuthor(author);
        meta.setCreateTime(createTime);
    }
}
