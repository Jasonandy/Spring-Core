package cn.ucaner.analyze.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
* @Package：cn.ucaner.analyze.ext   
* @ClassName：MyApplicationListener   
* @Description：   <p> MyApplicationListener </p>
* @Author： - Jason   
* @CreatTime：2018年7月6日 下午11:23:11   
* @Modify By：   
* @ModifyTime：  2018年7月6日
* @Modify marker：   
* @version    V1.0
 */
@Component
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {

	//当容器中发布此事件以后，方法触发
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("收到事件："+event);
	}

}
