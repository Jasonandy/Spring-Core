package cn.ucaner.tang;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import cn.ucaner.app.event.EmailEvent;
import cn.ucaner.app.service.Person;

/**
* @Package：cn.ucaner.tang   
* @ClassName：BeanTest   
* @Description：   <p> BeanTest </p>
* @Author： -    
* @Modify By：   
* @Modify marker：   
* @version    V1.0
 */
public class BeanTest {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
//        codeForIOC();
//        xmlBeanFactory();
        publishEvent();
//        other();
    }


    //编程式使用ioc基本容器
    public static void codeForIOC() {
        // 使用beanFactory初始化
        // 使用beanFactory初始化不会预初始化bean
        Resource resource = new ClassPathResource("beans.xml");
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        new XmlBeanDefinitionReader(beanFactory).loadBeanDefinitions(resource);
        System.out.println("-----容器启动成功-------");
        /* 1 setting注入*/
//        Person man = (Person) beanFactory.getBean("chinese");
//        man.useAxe();
        /* 2. 构造器注入，3.也可看注解型的注入 */
//        beanFactory.getBean("america");

        /* spring 为抽象方法的默认实现 */
//        Japan japan = (Japan) beanFactory.getBean("japan");
//        japan.hunt();

         /* 查看beanFactory基本功能 */
//        System.out.println("系统获取son1:" + beanFactory.getBean("field"));
//        //是否单例或多例
//        System.out.println("是否单例"+ beanFactory.isSingleton("stoneaxe"));
//        System.out.println("是否多例"+ beanFactory.isPrototype("steelaxe"));
//        System.out.println("是否是指定类" + beanFactory.isTypeMatch("steelaxe", SteelAxe.class));
//        System.out.println(beanFactory.getType("stoneaxe"));
    }

    /**
     * 最简版的实现beanFactory
     */
    public static void xmlBeanFactory(){
        /* 和codeForIOC()中创建IOC是一样的 */
        Resource resource = new ClassPathResource("beans.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        System.out.println("系统获取son1:" + beanFactory.getBean("field"));
    }

    public static void other() {
        // 创建Spring容器,根据ConfigLocation获取resource
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        Person p = ctx.getBean("america", Person.class);
        p.useAxe();

        System.out.println("系统获取son1:" + ctx.getBean("field"));
    }

    /**
     * 容器事件触发
     */
    public static void publishEvent() {
        // 创建Spring容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        EmailEvent emailEvent = new EmailEvent("ctx","地址","文本");
        // 注意里第一次触发是因为容器启动事件触发。AbstractApplicationContext，publishEvent（）
        // 第二次才是咱们的自定义触发事件。
        ctx.publishEvent(emailEvent);
    }



}
