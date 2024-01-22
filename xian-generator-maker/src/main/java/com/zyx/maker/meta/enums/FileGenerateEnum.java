package com.zyx.maker.meta.enums;

/**
 * 文件生成类型枚举
 * @author zyx
 * @version 1.0
 * @date 2024/1/22 022 9:17
 */
public enum FileGenerateEnum {
    DYNAMIC("dynamic", "动态"),
    STATIC("static", "静态");
    private final String value;
    private final String text;

    FileGenerateEnum(String value, String text) {
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
