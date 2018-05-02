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
	
	// 关键 -> 往注册表中注册一个新的 BeanDefinition 实例 
	void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
	
	//移除注册表中已注册的 BeanDefinition 实例
	void removeBeanDefinition(String beanName);

}
