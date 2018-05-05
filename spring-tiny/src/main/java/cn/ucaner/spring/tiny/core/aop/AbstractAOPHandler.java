package cn.ucaner.spring.tiny.core.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
* @Package：cn.ucaner.spring.tiny.core.aop   
* @ClassName：AbstractAOPHandler   
* @Description：   <p> AbstractAOPHandler 
* 
* - aop 切面处理
* </p>
* @Author： - chenwentao   
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public abstract class AbstractAOPHandler implements InvocationHandler{
	
	protected Object object;
	
	public AbstractAOPHandler(Object object){
		this.object=object;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object ret=method.invoke(object, args);
		return ret;
	}
	
}
