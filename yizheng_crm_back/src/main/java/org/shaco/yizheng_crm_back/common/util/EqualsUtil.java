package org.shaco.yizheng_crm_back.common.util;



import lombok.NonNull;
import org.shaco.yizheng_crm_back.common.IDict;

import java.util.Objects;

/**
 * 比较工具类
 */
public class EqualsUtil {

    private EqualsUtil() {
    }

    public static boolean anyEquals(@NonNull Object target, @NonNull Object... params) {
        for (Object param : params) {
            if (Objects.equals(target, param)) {
                return true;
            }
        }
        return false;
    }

    public static boolean anyEqualsIDict(@NonNull Integer target, @NonNull IDict... dictArray) {
        for (IDict dict : dictArray) {
            if (Objects.equals(target, dict.getCode())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAnyNull(@NonNull Object... params) {
        for (Object param : params) {
            if (Objects.isNull(param)) {
                return true;
            }
        }
        return false;
    }

}
