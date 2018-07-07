package cn.ucaner.analyze;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.ucaner.analyze.bean.Person;
import cn.ucaner.analyze.config.MainConfig;

public class MainTest {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
	/*	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:beans.xml");
		Person bean = (Person) applicationContext.getBean("person");
		System.out.println(bean);*/
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		Person bean = applicationContext.getBean(Person.class);
		System.out.println(bean);
		
		String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
		for (String name : namesForType) {
			System.out.println(name);
		}
	
	}

}
