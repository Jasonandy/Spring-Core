package cn.ucaner.maxwell.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * AOP测试启动类.
 */
public class Bootstrap {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:config.xml");
        SimpleAopBean bean = context.getBean(SimpleAopBean.class);
        bean.testB();
        System.out.println(bean.getClass().getSimpleName());
        System.out.println(context.getId());
        context.close();
    }

}
//Outputs

//SimpleMethodInterceptor被调用: testB
//testB执行
//SimpleMethodInterceptor被调用: testC
//testC执行
//SimpleAopBean$$EnhancerBySpringCGLIB$$e066b201
//org.springframework.context.support.ClassPathXmlApplicationContext@69d0a921