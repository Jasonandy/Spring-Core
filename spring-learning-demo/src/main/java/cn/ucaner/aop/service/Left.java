package cn.ucaner.aop.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
* @Package：cn.ucaner.aop.service   
* @ClassName：Left   
* @Description：   <p> Left</p>
* @Author： -    
* @Modify By：   
* @Modify marker：   
* @version    V1.0
 */
public class Left implements BeanNameAware, ApplicationContextAware,InitializingBean {

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("容器初始化后执行我~");
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		System.out.println("获得Spring上下文" + arg0);
	}

	@Override
	public void setBeanName(String arg0) {
		System.out.println("获得id名" + arg0);
	}

}
