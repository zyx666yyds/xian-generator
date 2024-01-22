package com.zyx.maker.meta.enums;

/**
 * 文件类型枚举
 * @author zyx
 * @version 1.0
 * @date 2024/1/22 022 9:15
 */
public enum FileTypeEnum {
    DIR("dir", "目录"),
    FILE("file", "文件");

    private final String value;
    private final String text;

    FileTypeEnum(String value, String text) {
        this.value = value;
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}
