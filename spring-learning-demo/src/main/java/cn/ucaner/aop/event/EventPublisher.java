package cn.ucaner.aop.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
* @Package：cn.ucaner.aop.event   
* @ClassName：EventPublisher   
* @Description：   <p> EventPublisher </p>
* @Author： -    newtonk
* @Modify By：   
* @Modify marker：   
* @version    V1.0
 */
public class EventPublisher implements ApplicationEventPublisherAware{
	
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public  void sendMessge(){
        EmailEvent emailEvent = new EmailEvent("ctx","地址","文本");
        applicationEventPublisher.publishEvent(emailEvent);
    }


}
