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
 * @Description：   <p> MsgEventPublisher 时间发布类</p>
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
        applicationContext.publishEvent(new MsgEvent(this, phoneNum, content));
    }
}
