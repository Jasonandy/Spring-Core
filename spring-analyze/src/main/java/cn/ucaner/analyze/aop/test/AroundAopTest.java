package cn.ucaner.analyze.aop.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.ucaner.analyze.aop.bean.Chinese;

/**
* @Package：cn.ucaner.analyze.aop.test   
* @ClassName：AroundAopTest   
* @Description：   <p> 环绕通知测试
* https://blog.csdn.net/csdn_terence/article/details/55804421
* </p>
* @Author： - Jason   
* @CreatTime：2018年5月15日 下午3:07:08   
* @Modify By：   
* @ModifyTime：  2018年5月15日
* @Modify marker：   
* @version    V1.0
 */
public class AroundAopTest {

    private static ApplicationContext ctx;

	public static void main(String[] args) {
        ctx = new ClassPathXmlApplicationContext("classpath*:spring-config/spring-core.xml");
        Chinese p = ctx.getBean(Chinese.class);//xml注入
        System.out.println("[Spring-Analyze:Jason]This is a Executing Clazz.:"+p.getClass());
        p.eat("Food");
       // p.sayHello("Hello");
    }
}
//Outputs

//This is a Executing Clazz.:class com.sun.proxy.$Proxy8   - start.  JDK代理
// Returning cached instance of singleton bean 'aroundAdvice'
//aroundAop 开始执行 
//传入参数:Food
// Returning cached instance of singleton bean 'aroundAdvice'
//aroundAop 开始执行 
//传入参数:Food
//I'm eating  :Food
//执行结果:null
//aroundAop 执行结束 
//执行结果:null
//aroundAop 执行结束 


//sayHello()
//[Spring-Analyze:Jason]This is a Executing Clazz.:class com.sun.proxy.$Proxy8
//-- 正在执行 sayHello 方法 --
//- Returning cached instance of singleton bean 'afterReturningAdvice'
//afterReturnAop 开始执行 
//获取目标方法返回值 :Hello Hello , Spring AOP
//模拟记录日志功能 ...
//afterReturnAop 执行结束 
//- Returning cached instance of singleton bean 'afterReturningAdvice'
//afterReturnAop 开始执行 
//获取目标方法返回值 :Hello Hello , Spring AOP
//模拟记录日志功能 ...
//afterReturnAop 执行结束 