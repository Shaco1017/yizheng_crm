package org.shaco.yizheng_crm_back.common;

import lombok.Data;

/**
 * 字典bean
 * 只有code和text，可用于展示下拉框
 *
 * @author shaco
 * @since 2025-03-28
 */
@Data
public class DictBean<T> implements IDict<T> {
    private final T code;
    private final String text;
}