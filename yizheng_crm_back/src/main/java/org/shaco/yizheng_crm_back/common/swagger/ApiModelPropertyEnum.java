package org.shaco.yizheng_crm_back.common.swagger;

import org.shaco.yizheng_crm_back.common.IDict;

import java.lang.annotation.*;

/**
 * Swagger文档注释枚举翻译
 * TODO 看不懂
 */
@Documented
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiModelPropertyEnum {

    /**
     * 属性对应的字段枚举
     */
    Class<? extends IDict<?>> dictEnum();

}
