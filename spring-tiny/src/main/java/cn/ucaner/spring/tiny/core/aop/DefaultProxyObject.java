package cn.ucaner.spring.tiny.core.aop;

import java.lang.reflect.Proxy;

public class DefaultProxyObject extends AbstractProxy{

	@Override
	public  Object getProxyObject(Object obj, Aop aop) {
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), 
				obj.getClass().getInterfaces(), 
				new DefaultAOPHandler(obj,aop));
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getProxyObjectByType(Class<T> clz, Aop aop){
		Object obj=null;
		try {
			obj= getProxyObject(clz.newInstance(),aop);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (T)obj;
	}
}
