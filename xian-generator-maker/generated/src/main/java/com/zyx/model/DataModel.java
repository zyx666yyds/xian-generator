package com.zyx.model;

import lombok.Data;

/**
* @author zyx
* @version 1.0
* @date 2024/1/17 017 17:25
*/
@Data
public class DataModel {

        /**
        * 是否生成循环
        */
    public boolean loop = false;


        /**
        * 作者注释
        */
    public String author = "zyx";


        /**
        * 输出信息
        */
    public String outputText = "sum = ";

}
