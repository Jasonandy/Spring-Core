package cn.ucaner.aop.publisher;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import cn.ucaner.aop.event.EmailEvent;

/**
* @Package：cn.ucaner.aop.event   
* @ClassName：EventPublisher   
* @Description：   <p> EventPublisher </p>
* @Author： -    newtonk
* @Modify By：   
* @Modify marker：   
* @version    V1.0
 */
@Component
public class EmailEventPublisher implements ApplicationEventPublisherAware{
	
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public  void sendMessge(){
    	//发布时间
        EmailEvent emailEvent = new EmailEvent("ctx","地址","文本");
        applicationEventPublisher.publishEvent(emailEvent);
        System.out.println("Has publish email!");
    }

}