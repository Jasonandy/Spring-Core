package cn.ucaner.spring.tiny.beans.factory;

import cn.ucaner.spring.tiny.beans.config.BeanDefinition;
import cn.ucaner.spring.tiny.exception.BeansException;
import cn.ucaner.spring.tiny.exception.NoSuchBeanDefinitionException;

/**
* @Package：cn.ucaner.spring.tiny.beans.factory   
* @ClassName：BeanFactory   
* @Description：   <p> 定义容器的基本雏形 </p>
* @Author： - chenwentao    
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public interface BeanFactory {
	
	 Object getBean(String name) throws BeansException;
	 
	 <T> T getBean(String name,Class <T> requiredType) throws BeansException;
	 
	 boolean containsBeanDefintion(String beanDefinitionName);
	 
	 boolean isSingleton(String beanDefinitionName) throws NoSuchBeanDefinitionException;
	 
	 BeanDefinition getBeanDefinition(String beanDefinitionName);
}
