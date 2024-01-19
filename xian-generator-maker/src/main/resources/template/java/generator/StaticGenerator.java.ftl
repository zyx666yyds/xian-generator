package ${basePackage}.generator.file;

import cn.hutool.core.io.FileUtil;

/**
 * 静态文件生成器
 *
 * @author zyx
 * @version 1.0
 * @date 2024/1/17 017 15:33
 */
public class StaticFileGenerator {

    /**
     * 使用Hutool工具类复制文件
     *
     * @param inputPath  输入文件路径
     * @param outputPath 输出文件路径
     */
    public static void copyFilesByHutool(String inputPath, String outputPath) {
        FileUtil.copy(inputPath, outputPath, false);
    }
}
