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

	/**
	 * @Description: ClassPathXmlApplicationContext
	 * @param args void
	 * @Autor: jason - jasonandy@hotmail.com
	 */
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:config.xml");
        SimpleAopBean bean = context.getBean(SimpleAopBean.class);//SimpleAopBean   xml注入
        bean.testB();//invoke()
        
        
        System.out.println(bean.getClass().getSimpleName());//SimpleAopBean$$EnhancerBySpringCGLIB$$b61487fc
        System.out.println(context.getId());//org.springframework.context.support.ClassPathXmlApplicationContext@799f7e29
        context.close();
    }

}
//Outputs
//SimpleMethodInterceptor被调用: testB
//SimpleAopBean:testB执行
//SimpleMethodInterceptor被调用: testC
//SimpleAopBean-currentProxy:testC执行
//SimpleAopBean$$EnhancerBySpringCGLIB$$b61487fc
//org.springframework.context.support.ClassPathXmlApplicationContext@799f7e29