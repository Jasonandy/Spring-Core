package cn.ucaner.analyze.aop.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.ucaner.analyze.aop.factory.Car;

/**
* @Package：cn.ucaner.analyze.aop.test   
* @ClassName：FactoryBeanTest   
* @Description：   <p> FactoryBeanTest </p>
* @Author： - Jason   
* @CreatTime：2018年5月15日 下午3:24:29   
* @Modify By：   
* @ModifyTime：  2018年5月15日
* @Modify marker：   
* @version    V1.0
 */
public class FactoryBeanTest {

    private static ApplicationContext ctx;

	public static void main(String[] args) {
       // ctx = new ClassPathXmlApplicationContext("classpath*:/spring-config/spring-core.xml");
        ctx = new ClassPathXmlApplicationContext("classpath*:/spring-config/spring-core.xml");
        /**
         * No qualifying bean of type [cn.ucaner.analyze.aop.factory.Car] is defined
         * 如果去掉Factory的注入的话 找不到CarImplBean实例
         * 
         * @Component - CarFactory
         */
        Car car = ctx.getBean(Car.class);
        car.driveCar();
        car.saleCar();
        
        /**
         * class cn.ucaner.analyze.aop.factory.CarFactory
         * 拿到的&是工厂Bean
         */
        System.out.println(ctx.getBean("&carFactory").getClass()); 
        
        /**
         * class cn.ucaner.analyze.aop.factory.impl.AudiCarImpl
         * 拿到的是实例Bean
         */
        System.out.println(ctx.getBean("carFactory").getClass());  

    }

}
//Outputs

//Audi car drive .
//Audi car sale .
//Returning cached instance of singleton bean 'carFactory'
//class cn.ucaner.analyze.aop.factory.CarFactory
//Returning cached instance of singleton bean 'carFactory'
//class cn.ucaner.analyze.aop.factory.impl.AudiCarImpl