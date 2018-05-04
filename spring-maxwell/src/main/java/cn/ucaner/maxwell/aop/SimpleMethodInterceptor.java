package cn.ucaner.maxwell.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
* @Package：cn.ucaner.maxwell.aop   
* @ClassName：SimpleMethodInterceptor   
* @Description：   <p> simpleMethodInterceptor </p>
* @Author： - Jason    
* @CreatTime：2018年5月4日 上午10:40:49   
* @Modify By：   
* @ModifyTime：  2018年5月4日
* @Modify marker：   
* @version    V1.0
 */
public class SimpleMethodInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("SimpleMethodInterceptor被调用: " + invocation.getMethod().getName());
        return invocation.proceed();
    }

}
