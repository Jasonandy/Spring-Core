package cn.ucaner.analyze.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
* @Package：cn.ucaner.analyze.ext   
* @ClassName：UserService   
* @Description：   <p> UserService </p>
* @Author： - Jason   
* @CreatTime：2018年7月6日 下午11:24:54   
* @Modify By：   
* @ModifyTime：  2018年7月6日
* @Modify marker：   
* @version    V1.0
 */
@Service
public class UserService {
	
	@EventListener(classes={ApplicationEvent.class})
	public void listen(ApplicationEvent event){
		System.out.println("UserService。。监听到的事件："+event);
	}

}
