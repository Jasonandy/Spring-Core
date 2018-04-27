package cn.ucaner.spring.tiny.beans.factory.support;

import cn.ucaner.spring.tiny.beans.config.BeanDefinition;

/**
* @Package：cn.ucaner.spring.tiny.beans.factory.support   
* @ClassName：BeanDefinitionRegistry   
* @Description：   <p> BeanDefinitionRegistry </p>
* @Author： -    
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public interface BeanDefinitionRegistry {
	
	void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
	
	void removeBeanDefinition(String beanName);

}
