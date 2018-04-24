package cn.ucaner.aop.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Date;
import java.util.Locale;

/**
* @Package：cn.ucaner.aop.service   
* @ClassName：ApplicationContextAwareTest   
* @Description：   <p> 实现ApplicationContextAware接口获得spring上下文 </p>
* @Author： -    lenovo
* @Modify By：   
* @Modify marker：   
* @version    V1.0
 */
public class ApplicationContextAwareTest implements ApplicationContextAware {
	
	// Spring容器上下文
	private ApplicationContext application;

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		this.application = arg0;
	}

	public void sayHi() {
		System.out.println(application.getMessage("now",
				new Object[] { new Date() },
				Locale.getDefault(Locale.Category.FORMAT)));
	}

}
