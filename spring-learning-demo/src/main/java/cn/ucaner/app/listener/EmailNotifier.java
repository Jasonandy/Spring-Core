package cn.ucaner.app.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import cn.ucaner.app.event.EmailEvent;


/**
* @Package：cn.ucaner.app.listener   
* @ClassName：EmailNotifier   
* @Description：   <p> EmailNotifier </p>
* @Author： -    newtonk
* @Modify By：   
* @Modify marker：   
* @version    V1.0
 */
public class EmailNotifier implements ApplicationListener {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof EmailEvent) {
			EmailEvent email = (EmailEvent) event;
			System.out.println("收件地址：" + email.getAddress());
			System.out.println("邮件内容" + email.getText());
		} else {
			System.out.println("其他事件" + event);
		}
	}

}
