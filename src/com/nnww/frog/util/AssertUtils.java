package com.nnww.frog.util;


import com.nnww.frog.entity.exception.DataException;

public class AssertUtils {

    public static void paramNotNull(Object parameter, String parameterName) {
        if (parameter == null) {
            throw new DataException(String.format("the param %s is null", parameterName));
        }
    }

    public static void notNull(Object parameter, String content) {
        if (parameter == null) {
            throw new DataException(content);
        }
    }

    public static void throwMsg(String content) {
        throw new DataException(content);
    }

    public static boolean strEmpty(String str) {
        return str == null || str.equals("");
    }

}
