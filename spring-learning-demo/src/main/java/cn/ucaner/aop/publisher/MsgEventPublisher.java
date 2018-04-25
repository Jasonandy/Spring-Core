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
package cn.ucaner.aop.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import cn.ucaner.aop.event.MsgEvent;

/**     
 * @Package：cn.ucaner.aop.publisher   
 * @ClassName：MsgEventPublisher   
 * @Description：   <p> MsgEventPublisher事件发布类 - ApplicationContext 发布事件  发布的时候会被触发 
 * http://www.importnew.com/20890.html
 * 
 * 		[ApplicationEvent：容器事件，必须由ApplicationContext发布]
 * 
 * 	Spring的事件机制与所有时间机制都基本相似，它们都需要事件源、事件和事件监听器组成。
 * 	只是此处的事件源是ApplicationContext，且事件必须由Java程序显式触发
 * </p>
 * @Author： - Jason   
 * @CreatTime：2018年4月25日 下午4:58:37   
 * @Modify By：   
 * @ModifyTime：  2018年4月25日
 * @Modify marker：   
 * @version    V1.0
 */
@Component
public class MsgEventPublisher {

	@Autowired
    private ApplicationContext applicationContext;
    
	/**
	 * @Description: pushlish 
	 * @param phoneNum
	 * @param content void
	 * @Autor: Jason - jasonandy@hotmail.com
	 */
    public void pushlish(String phoneNum, String content){
    	//applicationContext event1 event2 etc...
        applicationContext.publishEvent(new MsgEvent(this, phoneNum, content));
    }
}
