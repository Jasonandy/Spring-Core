package cn.ucaner.spring.tiny.beans.factory.support;

import cn.ucaner.spring.tiny.beans.config.BeanDefinition;

public interface BeanDefinitionRegistry {
	
	//註冊功能
	void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
	
	void removeBeanDefinition(String beanName);

}
