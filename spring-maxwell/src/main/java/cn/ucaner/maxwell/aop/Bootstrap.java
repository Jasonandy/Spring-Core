package cn.ucaner.maxwell.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
* @Package：cn.ucaner.maxwell.aop   
* @ClassName：Bootstrap   
* @Description：   <p> AOP测试启动类. </p>
* @Author： - Jason    
* @CreatTime：2018年5月4日 上午10:40:18   
* @Modify By：   
* @ModifyTime：  2018年5月4日
* @Modify marker：   
* @version    V1.0
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