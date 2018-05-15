package cn.ucaner.analyze.aop.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
* @Package：cn.ucaner.analyze.aop.aspect   
* @ClassName：AfterReturningAdvice   
* @Description：   <p> 
* AfterReturningAdvice
* AspectJ : https://blog.csdn.net/csdn_terence/article/details/55804421
* </p>
* @Author： - Jason   
* @CreatTime：2018年5月15日 下午3:14:55   
* @Modify By：   
* @ModifyTime：  2018年5月15日
* @Modify marker：   
* @version    V1.0
 */
@Component
@Aspect
public class AfterReturningAdvice {

	/**
	 * @Description: 所有方法的执行作为切入点
	 * @param rvt void
	 * @Autor: Jason - jasonandy@hotmail.com
	 */
    @AfterReturning(returning = "rvt", pointcut = "chinese()")
    public void log(Object rvt) {
        System.out.println("afterReturnAop 开始执行 ");
        System.out.println("获取目标方法返回值 :" + rvt);
        System.out.println("模拟记录日志功能 ...");
        System.out.println("afterReturnAop 执行结束 ");

    }

    @Pointcut("execution(* cn.ucaner.analyze.aop.bean.Chinese.sayHello(..))")
    public void chinese() {}

}
