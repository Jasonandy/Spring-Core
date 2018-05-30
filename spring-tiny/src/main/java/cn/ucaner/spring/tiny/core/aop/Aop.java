package cn.ucaner.spring.tiny.core.aop;

import java.lang.reflect.Method;

/**
* @Package：cn.ucaner.spring.tiny.core.aop   
* @ClassName：Aop   
* @Description：   <p> Aop
* 
*  - aop 
* </p>
* @Author： -    
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public interface Aop{
	
	/**
	 * @Description: after 
	 * @param proxy
	 * @param method
	 * @param args void
	 * @Autor: JASON - Jasonandy@hotmail.com
	 */
	void after(Object proxy, Method method, Object[] args);
		
	/**
	 * @Description: before 
	 * @param proxy
	 * @param method
	 * @param args void
	 * @Autor: Jason - jasonandy@hotmail.com
	 */
	void before(Object proxy, Method method, Object[] args);

}
