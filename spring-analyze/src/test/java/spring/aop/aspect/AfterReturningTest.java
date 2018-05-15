package spring.aop.aspect;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import spring.BaseTest;
import cn.ucaner.analyze.aop.bean.Chinese;

/**
* @Package：spring.aop.aspect   
* @ClassName：AfterReturningTest   
* @Description：   <p> AfterReturningTest</p>
* @Author： -    
* @CreatTime：2018年5月15日 下午3:40:55   
* @Modify By：   
* @ModifyTime：  2018年5月15日
* @Modify marker：   
* @version    V1.0
 */
public class AfterReturningTest extends BaseTest {

    @Autowired
    private Chinese chinese;

    @Test
    public void afterReturning(){
        String result = chinese.sayHello("hello");
        System.out.println(result);
    }
}
//Outputs
//-- 正在执行 sayHello 方法 --
//Returning cached instance of singleton bean 'afterReturningAdvice'
//afterReturnAop 开始执行 
//获取目标方法返回值 :hello Hello , Spring AOP
//模拟记录日志功能 ...
//afterReturnAop 执行结束 
// Returning cached instance of singleton bean 'afterReturningAdvice'
//afterReturnAop 开始执行 
//获取目标方法返回值 :hello Hello , Spring AOP
//模拟记录日志功能 ...
//afterReturnAop 执行结束 
//hello Hello , Spring AOP
