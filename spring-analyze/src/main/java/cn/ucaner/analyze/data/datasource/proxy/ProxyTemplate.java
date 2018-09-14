package cn.ucaner.analyze.data.datasource.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import cn.ucaner.analyze.data.datasource.bean.ProxyContext;

/**
* @Package：cn.ucaner.analyze.data.datasource.proxy   
* @ClassName：ProxyTemplate   
* @Description：   <p> ProxyTemplate 代理类</p>
* @Author： - Jason   
* @CreatTime：2018年9月14日 下午12:35:12   
* @Modify By：   
* @ModifyTime：  2018年9月14日
* @Modify marker：   
* @version    V1.0
 */
public abstract class ProxyTemplate<T> implements InvocationHandler {

    private ProxyContext proxyContext;

    private T target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // JDK居然连这些方法也被代理了
        if (method.getName().equals("equals")) {
            return proxy == args[0];
        } else if (method.getName().equals("hashCode")) {
            return super.hashCode();
        } else if (method.getName().equals("toString")) {
            return toString();
        }

        return invokePoint(proxy,method,args);
    }

    public abstract Object invokePoint(Object proxy, Method method, Object[] args) throws Exception;

	public ProxyContext getProxyContext() {
		return proxyContext;
	}
	
	public void setProxyContext(ProxyContext proxyContext) {
		this.proxyContext = proxyContext;
	}
	
	public T getTarget() {
		return target;
	}

	public void setTarget(T target) {
		this.target = target;
	}
    
    
}
