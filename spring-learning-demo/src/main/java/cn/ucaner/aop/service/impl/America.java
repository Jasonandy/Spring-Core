package cn.ucaner.aop.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import cn.ucaner.aop.event.EmailEvent;
import cn.ucaner.aop.service.Axe;
import cn.ucaner.aop.service.Person;

/**
* @Package：cn.ucaner.aop.service.impl   
* @ClassName：America   
* @Description：   <p> America </p>
* @Author： -    newtonk
* @Modify By：   
* @Modify marker：   
* @version    V1.0
 */
public class America implements Person,ApplicationEventPublisherAware {
	
	private Axe axe;
	private ApplicationEventPublisher applicationEventPublisher;
	
//	@Autowired
	public America(@Qualifier("steelaxe") Axe axe) {
		this.axe = axe;
		System.out.println(axe);
	}

	@Override
	public void useAxe() {
		System.out.println(axe.chop());
//		sendMessge();
	}
	public  void sendMessge(){
		EmailEvent emailEvent = new EmailEvent("ctx","地址","文本");
		applicationEventPublisher.publishEvent(emailEvent);
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}

}
