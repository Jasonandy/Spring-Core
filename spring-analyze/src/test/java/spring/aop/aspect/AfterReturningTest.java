package spring.aop.aspect;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import spring.BaseTest;
import cn.ucaner.analyze.aop.bean.Chinese;


public class AfterReturningTest extends BaseTest {

    @Autowired
    private Chinese chinese;

    @Test
    public void afterReturning(){
        String result = chinese.sayHello("hello");
        System.out.println(result);
    }
}
