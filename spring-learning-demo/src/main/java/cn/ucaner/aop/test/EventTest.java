/**
 * <html>
 * <body>
 *  <P> Copyright 1994-2018 JasonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2018年4月25日 </p>
 *  <p> Created by Jason https://github.com/Jasonandy </p>
 *  </body>
 * </html>
 */
package cn.ucaner.aop.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.ucaner.aop.config.EventConfig;
import cn.ucaner.aop.publisher.MsgEventPublisher;

/**     
 * @Package：cn.ucaner.aop.test   
 * @ClassName：EventTest   
 * @Description：   <p> 事件测试类 - 事件监听、订阅的实现，内部实现原理是观察者设计模式 </p>
 * @Author： - Jason   
 * @CreatTime：2018年4月25日 下午5:04:08   
 * @Modify By：   
 * @ModifyTime：  2018年4月25日
 * @Modify marker：   
 * @version    V1.0
 */
public class EventTest {

	public static void main(String[] args) {
		
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(EventConfig.class);
        
        MsgEventPublisher msgEventPublisher=context.getBean(MsgEventPublisher.class);
        
        msgEventPublisher.pushlish("18688889999","Hello this Spring Event.");
        msgEventPublisher.pushlish("13766669999","I'm Spring Event.");
        
        context.close();
    }
}
//Outputs.
//****** MsgListenser -  Start ******
//注册成功,发送的手机号为:18688889999,消息摘要为:Hello this Spring Event.
//****** MsgListenser  -  End  ******
//****** MsgListenser -  Start ******
//注册成功,发送的手机号为:13766669999,消息摘要为:I'm Spring Event.
//****** MsgListenser  -  End  ******
