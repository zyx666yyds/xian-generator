package com.zyx.maker.template.model;

import com.zyx.maker.meta.Meta;
import lombok.Data;

/**
 * 模板制作配置
 * @author zyx
 * @version 1.0
 * @date 2024/1/27 027 11:29
 */
@Data
public class TemplateMakerConfig {

    private Long id;

    private Meta meta = new Meta();

    private String originProjectPath;

    private TemplateMakerFileConfig fileConfig = new TemplateMakerFileConfig();

    private TemplateMakerModelConfig modelConfig = new TemplateMakerModelConfig();

    private TemplateMakerOutputConfig outputConfig = new TemplateMakerOutputConfig();
}
