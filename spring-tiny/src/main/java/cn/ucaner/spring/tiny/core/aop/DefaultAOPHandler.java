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
	
	private Aop aop;

	public DefaultAOPHandler(Object object, Aop aop)
	{
		super(object);
		this.aop=aop;
		
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object ret=null;
		//修改的地方在这里哦
		this.aop.before(proxy, method, args);
		ret=method.invoke(object, args);
		//修改的地方在这里哦
		this.aop.after(proxy, method, args);
		return ret;
	}
	
}
