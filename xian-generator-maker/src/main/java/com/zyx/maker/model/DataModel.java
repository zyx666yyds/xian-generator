package com.zyx.maker.model;

import lombok.Data;

/**
 * @author zyx
 * @version 1.0
 * @date 2024/1/17 017 17:25
 */
@Data
public class DataModel {
    /**
     * 作者
     */
    private String author;
    /**
     * 输出信息
     */
    private String outputText;

    /**
     * 是否循环
     */
    private boolean loop;
}
