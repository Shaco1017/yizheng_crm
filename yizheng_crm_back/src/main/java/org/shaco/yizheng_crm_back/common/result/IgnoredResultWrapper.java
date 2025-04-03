package org.shaco.yizheng_crm_back.common.result;


import java.lang.annotation.*;

/**
 * @author shaco
 * @since 2025-03-31
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface IgnoredResultWrapper {
}
