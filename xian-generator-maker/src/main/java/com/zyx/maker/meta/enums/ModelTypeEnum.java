package com.zyx.maker.meta.enums;

/**
 * 模型类型枚举
 *
 * @author zyx
 * @version 1.0
 * @date 2024/1/22 022 9:19
 */
public enum ModelTypeEnum {

    STRING("String","字符串"),

    BOOLEAN("boolean","布尔值");

    private final String value;
    private final String text;

    ModelTypeEnum(String value, String text) {
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
