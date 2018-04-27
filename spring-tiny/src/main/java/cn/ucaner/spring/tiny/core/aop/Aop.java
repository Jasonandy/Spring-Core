package cn.ucaner.spring.tiny.core.aop;

import java.lang.reflect.Method;

/**
* @Package：cn.ucaner.spring.tiny.core.aop   
* @ClassName：Aop   
* @Description：   <p> Aop</p>
* @Author： -    
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public interface Aop{
	
	void after(Object proxy, Method method, Object[] args);
		
	void before(Object proxy, Method method, Object[] args);

}
