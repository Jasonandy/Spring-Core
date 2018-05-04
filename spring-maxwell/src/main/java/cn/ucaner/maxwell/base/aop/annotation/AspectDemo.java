package cn.ucaner.maxwell.base.aop.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
* @Package：cn.ucaner.maxwell.base.aop.annotation   
* @ClassName：AspectDemo   
* @Description：   <p> AspectDemo</p>
* @Author： - Jason    
* @CreatTime：2018年5月4日 上午10:41:02   
* @Modify By：   
* @ModifyTime：  2018年5月4日
* @Modify marker：   
* @version    V1.0
 */
@Aspect
public class AspectDemo {

    @Pointcut("execution(void base.aop.AopDemo.send(..))")
    public void beforeSend() {}

    @Before("beforeSend()")
    public void before() {
        System.out.println("send之前");
    }

}
