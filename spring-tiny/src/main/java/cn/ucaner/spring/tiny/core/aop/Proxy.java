package cn.ucaner.spring.tiny.core.aop;

/**
* @Package：cn.ucaner.spring.tiny.core.aop   
* @ClassName：Proxy   
* @Description：   <p> Proxy
* 
*  - 代理接口
*  </p>
* @Author： -    
* @CreatTime：2018年4月27日 上午11:02:37   
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public interface Proxy {
	
	
	/**
	 * @Description: 获得代理类的对象
	 * @param obj
	 * @param AOP
	 * @return Object
	 * @Autor: Jason - jasonandy@hotmail.com
	 */
	Object getProxyObject(Object obj,Aop AOP);
}
