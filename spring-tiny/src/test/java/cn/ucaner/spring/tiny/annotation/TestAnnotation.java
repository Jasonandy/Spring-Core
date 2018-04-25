package cn.ucaner.spring.tiny.annotation;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.ucaner.spring.tiny.anntotion.handle.AutowiredHandle;
import cn.ucaner.spring.tiny.bean.AutowiredBean;
import cn.ucaner.spring.tiny.bean.BeanA;
import cn.ucaner.spring.tiny.beans.factory.DefaultListableBeanFactory;
import cn.ucaner.spring.tiny.core.io.FileSystemResource;

public class TestAnnotation {
	
	private static Logger log;
	DefaultListableBeanFactory defaultListableBeanFactory;
	
	@Before
	public void testDefaultListableBeanFactoryResource(){
		log = LoggerFactory.getLogger(DefaultListableBeanFactory.class);
		PropertyConfigurator.configure("log4j.properties");
		//注入一个resource
		FileSystemResource fsr = new FileSystemResource("resource/application.xml");
		try {
			 defaultListableBeanFactory=
					new DefaultListableBeanFactory(fsr);
			BeanA a=(BeanA)defaultListableBeanFactory.getBean("beana");
			log.debug(a.toString()+"");
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	public void TestAutowired() throws Exception{
		Object a=defaultListableBeanFactory.getBean("autowiredbean");
		Object b=defaultListableBeanFactory.getBean("beana");
		System.out.println(b);
		//类BeanA的对象我们已经放入了ioc容器，进行注入
		AutowiredHandle.AutowiredHandleMethod(AutowiredBean.class,defaultListableBeanFactory,
				"autowiredbean");
	    AutowiredBean ab=(AutowiredBean)a;
		log.info(ab.say());
	}

}
