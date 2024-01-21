package com.zyx.maker.generator;

import java.io.*;

/**
 * @author zyx
 * @version 1.0
 * @date 2024/1/19 019 19:48
 */
public class JarGenerator {

    public static void doGenerate(String projectDir) throws IOException, InterruptedException {

        String winMavenCommand = "mvn.cmd clean package -DskipTest=true";
        String  otherMavenCommand= "mvn clean package -DskipTest=true";
        String  mavenCommand= winMavenCommand;

        ProcessBuilder processBuilder = new ProcessBuilder(mavenCommand.split(" "));
        processBuilder.directory(new File(projectDir));

        Process process = processBuilder.start();
        //读取命令的输出
        InputStream inputStream = process.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        int exitCode = process.waitFor();

        System.out.println("退出码：" + exitCode);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        doGenerate("D:\\IdeaProjects\\xian-generator\\xian-generator-maker\\generated");
    }
}
