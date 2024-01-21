package com.zyx.maker.meta;

/**
 * @author zyx
 * @version 1.0
 * @date 2024/1/21 021 17:17
 */
public class MetaException extends RuntimeException{

    public MetaException(String message) {
        super(message);
    }

    public MetaException(String message, Throwable cause) {
        super(message, cause);
    }


}
