package cn.ucaner.maxwell.aop;

import org.springframework.aop.framework.AopContext;

/**
* @Package：cn.ucaner.maxwell.aop   
* @ClassName：SimpleAopBean   
* @Description：   <p> SimpleAopBean </p>
* @Author： - Jason    
* @CreatTime：2018年5月4日 上午10:40:28   
* @Modify By：   
* @ModifyTime：  2018年5月4日
* @Modify marker：   
* @version    V1.0
 */
public class SimpleAopBean {

    public void testA() {
        System.out.println("SimpleAopBean:testA执行->testB()");
        testB();
    }

    public void testB() {
        System.out.println("SimpleAopBean:testB执行");
        ((SimpleAopBean) AopContext.currentProxy()).testC();//SimpleMethodInterceptor被调用: testC
    }

    public void testC() {
        System.out.println("SimpleAopBean-currentProxy:testC执行");//last
    }

}
