package cn.ucaner.spring.tiny.core.aop;

import java.lang.reflect.Method;

/**
* @Package：cn.ucaner.spring.tiny.core.aop   
* @ClassName：DefaultAOPHandler   
* @Description：   <p> DefaultAOPHandler
* 
*  - 默认的aop切面处理器
* </p>
* @Author： -    
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public class DefaultAOPHandler extends AbstractAOPHandler{
	
	/**
	 * aop 对象
	 */
	private Aop aop;

	/**
	* DefaultAOPHandler. 
	* @param object
	* @param aop
	 */
	public DefaultAOPHandler(Object object, Aop aop){
		super(object);
		this.aop=aop;
	}

	/**
	 * invoke
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)throws Throwable {
		Object ret=null;
		this.aop.before(proxy, method, args);//before
		
		ret=method.invoke(object, args);
		
		this.aop.after(proxy, method, args);//after
		return ret;
	}
	
}
