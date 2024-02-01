package com.zyx.maker.template.model;

import lombok.Data;

/**
 * @author zyx
 * @version 1.0
 * @date 2024/1/31 031 11:01
 */
@Data
public class TemplateMakerOutputConfig {

    /**
     * 从未分组的文件中移除组内同名文件
     */
    private boolean removeGroupFilesFromRoot = true;
}
