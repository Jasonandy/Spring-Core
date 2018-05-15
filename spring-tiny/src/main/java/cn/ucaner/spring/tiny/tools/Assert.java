package cn.ucaner.spring.tiny.tools;

import java.util.Collection;

/**
* @Package：cn.ucaner.spring.tiny.tools   
* @ClassName：Assert   
* @Description：   <p> Assert 
* - 断言申明  -
* </p>
* @Author： -    
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public abstract class Assert {

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

	/**
	 * @Description: notNull
	 * @param locationPattern
	 * @param string void
	 * @Autor: wubin - binwu@pcitech.com
	 */
	public static void notNull(String locationPattern, String string) {
		if ("classpath:".startsWith(locationPattern)) {
			//合法
		}else {
			//不合法
		}
	}
	
	public static void isTrue(boolean expression, String message) {
		if (!expression) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void isTrue(boolean expression) {
		isTrue(expression, "[Assertion failed] - this expression must be true");
	}

	public static void isNull(Object object, String message) {
		if (object != null) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void notNull(Object object, String message) {
		if (object == null) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void notNull(Object object) {
		notNull(object, "[Assertion failed] - this argument is required; it must not be null");
	}


	public static void noNullElements(Object[] array, String message) {
		if (array != null) {
			for (Object element : array) {
				if (element == null) {
					throw new IllegalArgumentException(message);
				}
			}
		}
	}

	public static void noNullElements(Object[] array) {
		noNullElements(array, "[Assertion failed] - this array must not contain any null elements");
	}



	public static void isAssignable(Class<?> superType, Class<?> subType) {
		isAssignable(superType, subType, "");
	}

	public static void isAssignable(Class<?> superType, Class<?> subType, String message) {
		notNull(superType, "Type to check against must not be null");
		if (subType == null || !superType.isAssignableFrom(subType)) {
			throw new IllegalArgumentException(message + subType + " is not assignable to " + superType);
		}
	}


	public static void state(boolean expression, String message) {
		if (!expression) {
			throw new IllegalStateException(message);
		}
	}

	public static void state(boolean expression) {
		state(expression, "[Assertion failed] - this state invariant must be true");
	}

}
