package cn.ucaner.spring.tiny.core.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/*
 * @author chenwentao
 * @since  2017-01-25
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
