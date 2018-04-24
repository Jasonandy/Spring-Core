package cn.ucaner.analyze.aop.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyDemo implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class<?> clazz) {
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args,MethodProxy proxy) throws Throwable {
        //打印入参日志
        StringBuilder builder = new StringBuilder();
        if (args != null) {
            for (int i=0; i<args.length; ++i) {
                builder.append(",arg" + i + "=" + args[i].toString());
            }
        }
        System.out.println("Enter " + method.toString() + ",args:" + builder.toString());

//        Object result = method.invoke(obj, args); //直接使用obj调用方法，会发生和java动态代理一样的无限循环调用
        Object result = proxy.invokeSuper(obj, args);

        //打印结果日志
        System.out.println("Leave " + method.toString() + ",result=" + result.toString());
        return result;
    }
}
