package cn.ucaner.spring.tiny.context;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.ucaner.spring.tiny.beans.factory.AutowireCapableBeanFactory;
import cn.ucaner.spring.tiny.beans.factory.DefaultListableBeanFactory;
import cn.ucaner.spring.tiny.beans.factory.support.BeanDefinitionRegistry;
import cn.ucaner.spring.tiny.core.io.AnnotationBeanDefinitionReader;
import cn.ucaner.spring.tiny.core.io.Resource;

/*
 * @author chenwentao
 * @since  2017-01-25
 * 给AutowireApplicationContext增加自动注入的功能
 */
public class AutowireApplicationContext extends DefaultListableBeanFactory implements AutowireCapableBeanFactory{

	private static Logger log = LoggerFactory.getLogger(AutowireApplicationContext.class);
	static{
		PropertyConfigurator.configure("log4j.properties");
	}
	
	public AutowireApplicationContext(Resource resource) throws Exception
	{
		super(resource);
		refresh();
	}

	public AutowireApplicationContext(String location) throws Exception
	{
		super(location);
		refresh();
	}
	
	/*
	 * 继承ComponentHandle，拥有解析@component注解的能力
	 */
	private class AutowireAnnotationBeanDefinition extends AnnotationBeanDefinitionReader{
		public AutowireAnnotationBeanDefinition(BeanDefinitionRegistry registry)
		{
			super(registry);
		}
	}
	@Override
	protected void refresh() throws Exception {
		int count=new AutowireAnnotationBeanDefinition(this).loadBeanDefinitions(resource);
		log.info("一共初注册了:"+count+"个beanDefinition");
	}

    @Override
    public void AutowireBean() {
        
    }
}
