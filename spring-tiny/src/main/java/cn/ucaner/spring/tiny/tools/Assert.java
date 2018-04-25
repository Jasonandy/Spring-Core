package cn.ucaner.spring.tiny.tools;

import java.util.Collection;

public class Assert {

    public static boolean isNotEmpry(Collection<?> c) {
        return c != null && c.size() > 0;
    }

    public static String isNull(Object object) {
        return "Object  is  null?" + (object == null ? true : false);
    }

    public static boolean isEffectiveString(String value) {
        return value != null && !value.equals("");
    }
}
