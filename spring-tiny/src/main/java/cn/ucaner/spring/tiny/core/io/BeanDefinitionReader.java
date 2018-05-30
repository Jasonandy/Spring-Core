package cn.ucaner.spring.tiny.core.io;

import cn.ucaner.spring.tiny.beans.factory.support.BeanDefinitionRegistry;

/**
* @Package：cn.ucaner.spring.tiny.core.io   
* @ClassName：BeanDefinitionReader   
* @Description：   <p> BeanDefinitionReader 接口的作用就是加载 Bean </p>
* @Author： -    
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public interface BeanDefinitionReader {
	
	/**
	 * @Description: getBeanDefinitionRegistry  beanDefinition 注册器
	 * @return BeanDefinitionRegistry
	 * @Autor: Jason - Jasonandy@hotmai.com
	 */
	BeanDefinitionRegistry getBeanDefinitionRegistry();
	
	/**
	 * @Description: getResourceLoader 
	 * @return ResourceLoader
	 * @Autor: Jason - Jasonandy@hotmai.com
	 */
	ResourceLoader getResourceLoader();
	
	/**
	 * @Description:  通过 Resource s 加载 Bean 
	 * @param resources
	 * @return
	 * @throws Exception int
	 * @Autor: jason - jasonandy@hotmail.com
	 */
	int loadBeanDefinitions(Resource... resources) throws Exception;
	
	/**
	 * @Description:  通过 Resource 加载 Bean 
	 * @param resources
	 * @return
	 * @throws Exception int
	 * @Autor: jason - jasonandy@hotmail.com
	 */
	int loadBeanDefinitions(Resource resource) throws  Exception;
	
	
	/**
	 * @Description: 通过location加载bean
	 * @param location 配置文件的路径
	 * @return
	 * @throws Exception int
	 * @Autor:  jason - jasonandy@hotmail.com
	 */
	//int loadBeanDefinitions(String location) throws Exception;

	/**
	 * @Description: 通过location s 加载bean
	 * @param location 配置文件的路径
	 * @return
	 * @throws Exception int
	 * @Autor:  jason - jasonandy@hotmail.com
	 */
	//int loadBeanDefinitions(String... locations)  throws Exception;
	
}
