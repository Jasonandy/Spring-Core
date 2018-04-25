package cn.ucaner.spring.tiny.core.io;

import cn.ucaner.spring.tiny.beans.factory.support.BeanDefinitionRegistry;

public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{
	
	protected final BeanDefinitionRegistry registry;

	private ResourceLoader resourceLoader;
	
	public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry){
		this.registry=registry;
		this.resourceLoader = (ResourceLoader)this.registry;
	}

	@Override
	public BeanDefinitionRegistry getBeanDefinitionRegistry() {
		return this.registry;
	}

	@Override
	public ResourceLoader getResourceLoader() {
		return this.resourceLoader;
	}

	@Override
	public int loadBeanDefinitions(Resource... resources) throws Exception{
		// 在这里先简单实现，return the number of bean definitions found
		//这个方法是个死循环，也就是说继承这个类的子类必须重写loadBeanDefinitions(resource)，
		//真正返回the number of bean definitions found,再调用父类loadBeanDefinitions
		//方法，返回所有definition的个数，在这里并没有实现loadBeanDefinitions(resource)方法，
		//真正的实现交给继承它的子类
		int count=0;
		for(Resource resource:resources){
			count+=loadBeanDefinitions(resource);
		}
		return count;
	}
		
}
