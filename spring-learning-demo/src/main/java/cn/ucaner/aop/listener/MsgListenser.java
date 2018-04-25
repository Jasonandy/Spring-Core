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
package cn.ucaner.aop.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import cn.ucaner.aop.event.MsgEvent;

/**     
 * @Package：cn.ucaner.aop.listener   
 * @ClassName：MsgListenser   
 * @Description：   <p> MsgListenser 定义事件监听类    
 * 实现ApplicationListener接口，指定监听的事件类型
 * onApplicationEvent对消息进行接受处理[时间触发的时候进行处理]
 * </p>
 * @Author： - DaoDou   
 * @CreatTime：2018年4月25日 下午4:55:08   
 * @Modify By：   
 * @ModifyTime：  2018年4月25日
 * @Modify marker：   
 * @version    V1.0
 */
@Component
public class MsgListenser implements ApplicationListener<MsgEvent>{

	//使用注解@Async支持 这样不仅可以支持同步调用，也支持异步调用
    @Async
	@Override
	public void onApplicationEvent(MsgEvent event) {
    	System.out.println("****** MsgListenser -  Start ******");
    	System.out.println("注册成功,发送的手机号为:" + event.getPhoneNum()+",消息摘要为:"+event.getContent());
    	System.out.println("****** MsgListenser  -  End  ******");
	}

}
