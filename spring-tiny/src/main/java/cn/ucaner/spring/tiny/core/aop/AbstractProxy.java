package cn.ucaner.spring.tiny.core.aop;

/**
* @Package：cn.ucaner.spring.tiny.core.aop   
* @ClassName：AbstractProxy   
* @Description：   <p> AbstractProxy
* 
* - 抽象代理 - 
* </p>
* @Author： -    
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public abstract class AbstractProxy implements Proxy{
	
    @SuppressWarnings("unchecked")
	<T> T getProxyObjectBytype(Object obj,Aop aop){
    	return (T)getProxyObject(obj, aop);
    }
	
	<T> T getProxyObjectByClassName(String className,Aop aop) throws Exception{
		return getProxyObjectBytype(Class.forName(className).newInstance(),aop);
	}
	
	<T> T  getProxyObjectByType(Class<T> clz,Aop aop) throws Exception{
		return getProxyObjectBytype(clz.newInstance(),aop);
	}

}
