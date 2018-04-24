/**
 * <html>
 * <body>
 *  <P> Copyright 1994-2018 JasonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2018年4月24日 下午4:20:57</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.analyze.aop.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**     
 * @Package：cn.ucaner.analyze.aop.cglib   
 * @ClassName：CglibProxyHelper   
 * @Description：   <p> CglibProxyHelper cglib 代理 </p>
 * @Author： - Jason   
 * @CreatTime：2018年4月24日 下午4:20:57   
 * @Modify By：   
 * @ModifyTime：  2018年4月24日
 * @Modify marker：   
 * @version    V1.0
 */
public class CglibProxyHelper implements MethodInterceptor {

	private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class<?> clazz) {
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }
	    
	@Override
	public Object intercept(Object obj, Method method, Object[] args,MethodProxy proxy) throws Throwable {
		
		/**
		 * 日志记录（线程不安全）
		 */
        StringBuilder builder = new StringBuilder();
        if (args != null) {
            for (int i=0; i<args.length; ++i) {
                builder.append("Parmas[" + i + "]=" + args[i].toString()+",");
            }
        }
        doBefore();// 方法调用前处理
        System.out.println("Call Method " + method.toString() + " - args:" + builder.toString());

        Object result = proxy.invokeSuper(obj, args);

        doAfter();//方法调用后处理
        if (result !=null) {
        	System.out.println("The Call Method Result " + method.toString() + " - result=" + result.toString());
		}
        
        return result;
	}

	/**
	 * @Description: doBefore
	 * @Autor: Jason -jasonandy@hotmail.com
	 */
    private void doBefore(){  
        System.out.println("[Before method invoke .]");  
    }  
     
    /**
     * @Description: doAfter
     * @Autor: Jason - jasoandy@hotmail.com
     */
    private void doAfter(){  
        System.out.println("[After method invoke.]");  
    }  
}
