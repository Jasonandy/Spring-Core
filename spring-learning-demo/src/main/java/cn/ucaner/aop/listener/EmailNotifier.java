package cn.ucaner.aop.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import cn.ucaner.aop.event.EmailEvent;

/**
* @Package：cn.ucaner.aop.listener   
* @ClassName：EmailNotifier   
* @Description：   <p> EmailNotifier </p>
* @Author： -    newtonk
* @Modify By：   
* @Modify marker：   
* @version    V1.0
 */
public class EmailNotifier implements ApplicationListener<EmailEvent> {

	@Override
	public void onApplicationEvent(EmailEvent event) {
		if (event instanceof EmailEvent) {
			EmailEvent email = (EmailEvent) event;
			System.out.println("收件地址：" + email.getAddress());
			System.out.println("邮件内容" + email.getText());
		} else {
			System.out.println("其他事件" + event);
		}
	}

}
