package cn.ucaner.spring.tiny.core.io;

import cn.ucaner.spring.tiny.beans.factory.support.BeanDefinitionRegistry;

public interface BeanDefinitionReader {
	
	BeanDefinitionRegistry getBeanDefinitionRegistry();
	
	ResourceLoader getResourceLoader();
	
	int loadBeanDefinitions(Resource... resources) throws Exception;
	
	int loadBeanDefinitions(Resource resource) throws  Exception;
	
}
