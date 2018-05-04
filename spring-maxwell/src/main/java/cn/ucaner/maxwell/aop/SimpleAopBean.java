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

    public void boo() {
        System.out.println("testA执行");
        testB();
    }

    public void testB() {
        System.out.println("testB执行");
        ((SimpleAopBean) AopContext.currentProxy()).testC();
    }

    public void testC() {
        System.out.println("testC执行");
    }

}
