package cn.ucaner.analyze.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
* @Package：cn.ucaner.analyze.aop.aspect   
* @ClassName：AroundAdvice   
* @Description：   <p> 环绕通知
* AspectJ : https://blog.csdn.net/csdn_terence/article/details/55804421
* </p>
* @Author： - Jason   
* @CreatTime：2018年5月15日 下午3:02:43   
* @Modify By：   
* @ModifyTime：  2018年5月15日
* @Modify marker：   
* @version    V1.0
 */
@Component
@Aspect
public class AroundAdvice {

    @Around("eat()")
    public Object verify(ProceedingJoinPoint point) throws Throwable {
        System.out.println("aroundAop 开始执行 ");

        Object[] args = point.getArgs();
        for(Object arg : args){
            System.out.println("传入参数:"+arg);
        }
        Object returnObj = point.proceed(args);
        System.out.println("执行结果:"+returnObj);
        System.out.println("aroundAop 执行结束 ");
        return returnObj;
    }

    /**
     * @Description: execution
     * @Autor: Jason
     */
    @Pointcut("execution(* cn.ucaner.analyze.aop.bean.Chinese.eat(..))")
    public void eat() {
    	System.out.println("execution(* cn.ucaner.analyze.aop.bean.Chinese.(..))");
    }


}
