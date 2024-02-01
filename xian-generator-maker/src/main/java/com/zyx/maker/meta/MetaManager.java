package com.zyx.maker.meta;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONUtil;

/**
 * @author zyx
 * @version 1.0
 * @date 2024/1/19 019 11:08
 */
public class MetaManager {

    private static volatile Meta meta;

    /**
     * 单例模式
     * @return
     */
    public static Meta getMetaObject() {
        if (meta == null){
            synchronized (MetaManager.class) {
                if (meta == null) {
                    meta = initMeta();
                }
            }
        }
        return meta;
    }

    private static Meta initMeta(){
        String metaJson = ResourceUtil.readUtf8Str("springboot-init-meta.json");
        Meta newMeta = JSONUtil.toBean(metaJson, Meta.class);
        // 校验配置文件，恢复默认值
        MetaValidator.doValidAndFill(newMeta);
        return newMeta;
    }

}
