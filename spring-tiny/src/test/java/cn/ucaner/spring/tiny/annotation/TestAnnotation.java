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

/**
* @Package：cn.ucaner.spring.tiny.annotation   
* @ClassName：TestAnnotation   
* @Description：   <p> TestAnnotation</p>
* @Author： -    
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public class TestAnnotation {
	
	private static Logger logger = LoggerFactory.getLogger(TestAnnotation.class);;
	
	DefaultListableBeanFactory defaultListableBeanFactory;
	
	@Before
	public void testDefaultListableBeanFactoryResource(){
		//logger = LoggerFactory.getLogger(DefaultListableBeanFactory.class);
		//PropertyConfigurator.configure("src/main/resource/log4j.properties");
		//注入一个resource
		FileSystemResource fsr = new FileSystemResource("src/test/resource/application.xml");
		try {
			defaultListableBeanFactory= new DefaultListableBeanFactory(fsr);
			BeanA beana=(BeanA)defaultListableBeanFactory.getBean("beana");
			logger.info("beana - {}",beana.getName());
			System.out.println(beana);
			//log.debug(a.toString()+"");
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
		AutowiredHandle.AutowiredHandleMethod(AutowiredBean.class,defaultListableBeanFactory,"autowiredbean");
	    AutowiredBean ab=(AutowiredBean)a;
		//log.info(ab.say());
	}

}
