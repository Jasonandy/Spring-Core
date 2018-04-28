package cn.ucaner.spring.tiny.core.aop;

import java.lang.reflect.Method;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.ucaner.spring.tiny.bean.BeanA;
import cn.ucaner.spring.tiny.bean.jiekou;
import cn.ucaner.spring.tiny.beans.factory.DefaultListableBeanFactory;
import cn.ucaner.spring.tiny.core.io.FileSystemResource;

/**
* @Package：cn.ucaner.spring.tiny.core.aop   
* @ClassName：AopTest   
* @Description：   <p> AopTest
* java实现动态代理必须实现相同的接口，后期实现不需要实现相同的接口
* </p>
* @Author： - cwt   
* @Modify By：   
* @ModifyTime：  2018年4月28日
* @Modify marker：   
* @version    V1.0
 */
public class AopTest {
	
	private static Logger log = LoggerFactory.getLogger(DefaultListableBeanFactory.class);
	DefaultListableBeanFactory defaultListableBeanFactory;
	
	@Test
	public void testDefaultListableBeanFactoryResource(){
		PropertyConfigurator.configure("classpath:*/log4j.properties");
		//注入一个resource
		FileSystemResource fsr=new FileSystemResource("resource\\test.xml");
		try {
			 defaultListableBeanFactory=
					new DefaultListableBeanFactory(fsr);
			BeanA a=(BeanA)defaultListableBeanFactory.getBean("beana");
			log.debug(a.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void OriginalAopTest(){
		jiekou j=new DefaultProxyObject().getProxyObjectByType(BeanA.class, new Aop()
		{	
			@Override
			public void before(Object proxy, Method method, Object[] args) {
				System.out.println("before");	
			}
			
			@Override
			public void after(Object proxy, Method method, Object[] args) {
				System.out.println("after");
			}
	});
		j.aaa();
 }

	
	@Test
	public void AopAndIoc() throws Exception{
		PropertyConfigurator.configure("log4j.properties");
		//注入一个resource
		FileSystemResource fsr=new FileSystemResource("src\\resource\\test.xml");
		try {
			 defaultListableBeanFactory=
					new DefaultListableBeanFactory(fsr);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		System.out.println(defaultListableBeanFactory==null);
		DefaultProxyObject dpo=
				defaultListableBeanFactory.getBean("DefaultProxyObject", DefaultProxyObject.class);
		AspectJBeanA ajb=defaultListableBeanFactory.getBean("aspectbeana",AspectJBeanA.class );
		jiekou j=dpo.getProxyObjectByType(BeanA.class,ajb);
		j.aaa();
	}
	
	
	@Test
	public void sdasda(){
		jiekou j=new DefaultProxyObject().getProxyObjectByType(BeanA.class, new AspectJBeanA());
		j.aaa();
    }
}
