package com.zyx.maker.generator;


import cn.hutool.core.io.FileUtil;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;


/**
 * @author zyx
 * @version 1.0
 * @date 2024/1/19 019 20:56
 */
public class ScriptGenerator {

    public static void doGenerate(String outputPath, String jarPath) {
        StringBuffer stringBuffer = new StringBuffer();

        //linux
        stringBuffer.append("#!/bin/bash").append("\n");
        stringBuffer.append(String.format("java -jar %s \"$@\"", jarPath)).append("\n");
        FileUtil.writeBytes(stringBuffer.toString().getBytes(StandardCharsets.UTF_8), outputPath);
        //添加可执行权限

        try {
            Set<PosixFilePermission> permissions = PosixFilePermissions.fromString("rwxrwxrwx");
            Files.setPosixFilePermissions(Paths.get(outputPath), permissions);
        } catch (Exception ignored) {

        }

        //windows
        stringBuffer = new StringBuffer();
        stringBuffer.append("@echo off").append("\n");
        stringBuffer.append(String.format("java -jar %s %%*", jarPath)).append("\n");
        FileUtil.writeBytes(stringBuffer.toString().getBytes(StandardCharsets.UTF_8), outputPath + ".bat");
    }
}
