/**
 * <html>
 * <body>
 *  <P> Copyright  JasonInternational </p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason. The Source On WebSite .  https://github.com/Jasonandy/Spring-Core </p>
 *  </body>
 * </html>
 */
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
	
	/**
	 * @Description: 往注册表中注册一个新的 BeanDefinition 实例  
	 * @param beanName
	 * @param beanDefinition void
	 * @Autor: Jason - Jasonandy@hotmail.com
	 */
	void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
	
	/**
	 * @Description: 移除注册表中已注册的 BeanDefinition 实例 
	 * @param beanName void
	 * @Autor: Jason - Jasonany@hotmail.com
	 */
	void removeBeanDefinition(String beanName);

}
