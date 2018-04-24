package cn.ucaner.app.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
* @Package：cn.ucaner.app.aspect   
* @ClassName：TqAspect   
* @Description：   <p> TqAspect </p>
* @Author： - Jason   
* @CreatTime：2018年4月24日 上午10:59:44   
* @Modify By：   
* @ModifyTime：  2018年4月24日
* @Modify marker：   
* @version    V1.0
 */
//定义一个切面类
@Aspect
public class TqAspect {

	// 匹配org.tq.app.service包下所有类所有方法的执行作为切入点
	@Before("execution(* org.tq.app.service.impl.Hello.*(..))")
	public void before() {
		System.out.println("tqAspect brefore...");
	}

	@After("execution(* org.tq.app.service.impl.Hello.*(..))")
	public void relese() {
		System.out.println("不管方法是否成功完成都会执行我！！");
	}

	// 声明rvt时指定的类型会限制目标方法必须返回指定类型的值
	@AfterReturning(returning = "rvt", pointcut = "execution(* org.tq.app.service.impl.Hello.*(..))")
	public void log(Object rvt) {
		System.out.println("获取目标方法返回值" + rvt);
		System.out.println("模拟日志功能");
	}

	// 对异常的增强处理
	@AfterThrowing(throwing = "ex", pointcut = "execution(* org.tq.app.service.impl.Hello.*(..))")
	public void doRecoverActions(Throwable ex) {
		System.out.println("目标方法中抛出的异常：" + ex);
		System.out.println("模拟advice对异常的修复。。");
	}
}
