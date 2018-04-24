package cn.ucaner.analyze.aop.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.ucaner.analyze.aop.bean.Chinese;


public class AroundAopTest {

    public static void main(String[] args) {
        // 创建 Spring 容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config/spring-core.xml");
        Chinese p = ctx.getBean(Chinese.class);
        System.out.println("正在执行的类:"+p.getClass());
        p.eat("西瓜");
    }
}
