package cn.ucaner.maxwell.base.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
* @Package：cn.ucaner.maxwell.base.aop   
* @ClassName：AopDemoAdvice   
* @Description：   <p> AopDemoAdvice </p>
* @Author： - Jason    
* @CreatTime：2018年5月4日 上午10:41:26   
* @Modify By：   
* @ModifyTime：  2018年5月4日
* @Modify marker：   
* @version    V1.0
 */
public class AopDemoAdvice implements MethodInterceptor {

    public void beforeSend() {
        System.out.println("before send");
    }

    public void afterSend() {
        System.out.println("after send");
    }

    public void beforeReceive() {
        System.out.println("before receive");
    }

    public void afterReceive() {
        System.out.println("after receive");
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        return null;
    }
}
