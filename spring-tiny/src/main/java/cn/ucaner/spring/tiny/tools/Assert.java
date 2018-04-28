package cn.ucaner.spring.tiny.tools;

import java.util.Collection;

/**
* @Package：cn.ucaner.spring.tiny.tools   
* @ClassName：Assert   
* @Description：   <p> Assert </p>
* @Author： -    
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public class Assert {

	/**
	 * @Description: isNotEmpty 
	 * @param c
	 * @return boolean
	 */
    public static boolean isNotEmpty(Collection<?> c) {
        return c != null && c.size() > 0;
    }

    /**
     * @Description: isNull 
     * @param object
     * @return String
     */
    public static String isNull(Object object) {
        return "Object  is  null?" + (object == null ? true : false);
    }

    /**
     * @Description: isEffectiveString
     * @param value
     * @return boolean
     */
    public static boolean isEffectiveString(String value) {
        return value != null && !value.equals("");
    }
}
