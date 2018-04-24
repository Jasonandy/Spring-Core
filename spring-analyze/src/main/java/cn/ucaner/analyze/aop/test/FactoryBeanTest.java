package cn.ucaner.analyze.aop.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.ucaner.analyze.aop.factory.Car;

public class FactoryBeanTest {

    public static void main(String[] args) {
        // 创建 Spring 容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:/spring-config/spring-core.xml");
        Car car = ctx.getBean(Car.class);
        car.driveCar();
        car.saleCar();
        System.out.println(ctx.getBean("&carFactory").getClass());
        System.out.println(ctx.getBean("carFactory").getClass());

    }

}
