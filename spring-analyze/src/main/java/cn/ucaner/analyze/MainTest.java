package cn.ucaner.analyze;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.ucaner.analyze.bean.Person;
import cn.ucaner.analyze.config.MainConfig;

public class MainTest {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		/**
		 * xml bean 获取 
		 */
	/*	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:beans.xml");
		Person bean = (Person) applicationContext.getBean("person");
		System.out.println(bean);*/
		
		/**
		 * 注解方式获取bean
		 */
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		Person bean = applicationContext.getBean(Person.class);
		System.out.println(bean);
		
		/**
		 * 名字  方法名做id @bean
		 */
		String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
		for (String name : namesForType) {
			System.out.println(name);
		}
	
	}

}
