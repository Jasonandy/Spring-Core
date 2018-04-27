package cn.ucaner.spring.tiny.core.aop;

/**
* @Package：cn.ucaner.spring.tiny.core.aop   
* @ClassName：Proxy   
* @Description：   <p> Proxy </p>
* @Author： -    
* @CreatTime：2018年4月27日 上午11:02:37   
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public interface Proxy {
	//获得代理类的对象
	Object getProxyObject(Object obj,Aop AOP);
}
