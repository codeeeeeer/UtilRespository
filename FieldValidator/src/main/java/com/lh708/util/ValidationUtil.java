package com.lh708.util;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/6/30 9:08
 */
public class ValidationUtil {
    public static boolean equals(Object o1, Object o2){
        if (o1 == null && o2 == null) return true;
        if (o1 == null || o2 == null) return false;
        if (o1 instanceof String && o2 instanceof String)
            return ((String) o1).trim().equals(((String) o2).trim());
        return false;
    }

    public static boolean notEquals(Object o1, Object o2){
        return !equals(o1, o2);
    }

    public static boolean isEmpty(Object o1){
        if (o1 == null) return true;
        if (o1 instanceof String) return "".equals(((String) o1).trim());
        return false;
    }
}
