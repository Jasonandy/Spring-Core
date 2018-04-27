package cn.ucaner.spring.tiny.core.io;

import cn.ucaner.spring.tiny.beans.factory.support.BeanDefinitionRegistry;

/**
* @Package：cn.ucaner.spring.tiny.core.io   
* @ClassName：BeanDefinitionReader   
* @Description：   <p> BeanDefinitionReader </p>
* @Author： -    
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public interface BeanDefinitionReader {
	
	BeanDefinitionRegistry getBeanDefinitionRegistry();
	
	ResourceLoader getResourceLoader();
	
	int loadBeanDefinitions(Resource... resources) throws Exception;
	
	int loadBeanDefinitions(Resource resource) throws  Exception;
	
}
