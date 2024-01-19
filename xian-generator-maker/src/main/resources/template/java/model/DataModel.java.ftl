package ${basePackage}.model;

import lombok.Data;

/**
* @author zyx
* @version 1.0
* @date 2024/1/17 017 17:25
*/
@Data
public class DataModel {
<#list modelConfig.models as modelInfo>

    <#if modelInfo.description??>
        /**
        * ${modelInfo.description}
        */
    </#if>
    public ${modelInfo.type} ${modelInfo.fieldName}<#if modelInfo.defaultValue??> = ${modelInfo.defaultValue?c}</#if>;

</#list>
}
