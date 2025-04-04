package org.shaco.yizheng_crm_back.common.result;


import org.shaco.yizheng_crm_back.common.execption.BizException;
import org.shaco.yizheng_crm_back.common.execption.IResultCode;

import java.util.Collection;
import java.util.Objects;

public class Assert {

    public static void isTrue(boolean expression, IResultCode resultCode) {
        if (!expression) {
            throw new BizException(resultCode);
        }
    }

    public static void notTrue(boolean expression, IResultCode resultCode) {
        if (expression) {
            throw new BizException(resultCode);
        }
    }


    public static void isNull(Object object, IResultCode resultCode) {
        if (!Objects.isNull(object)) {
            throw new BizException(resultCode);
        }
    }

    public static void notNull(Object object, IResultCode resultCode) {
        if (Objects.isNull(object)) {
            throw new BizException(resultCode);
        }
    }

    public static void isEmpty(Collection<?> collection, IResultCode resultCode) {
        if (!Objects.isNull(collection) && !collection.isEmpty()) {
            throw new BizException(resultCode);
        }
    }

    public static void notEmpty(Collection<?> collection, IResultCode resultCode) {
        if (Objects.isNull(collection) || collection.isEmpty()) {
            throw new BizException(resultCode);
        }
    }

}
