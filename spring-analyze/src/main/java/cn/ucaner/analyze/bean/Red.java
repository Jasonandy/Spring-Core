package cn.ucaner.analyze.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
* @Package：cn.ucaner.analyze.bean   
* @ClassName：Red   
* @Description：   <p> Red 
* 
* 
* ApplicationContextAware:  上下文的处理
* 
* 
* BeanNameAware: 创建对象- 时候 - 给bean取的啥名字
* 
* 
* EmbeddedValueResolverAware: 嵌入式的值解析器
* </p>
* @Author： - Jason   
* @CreatTime：2018年7月6日 下午11:11:39   
* @Modify By：   
* @ModifyTime：  2018年7月6日
* @Modify marker：   
* @version    V1.0
 */
@Component //加入ioc容器
public class Red implements ApplicationContextAware,BeanNameAware,EmbeddedValueResolverAware {
	
	private ApplicationContext applicationContext; //存起来 

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("传入的ioc："+applicationContext);
		this.applicationContext = applicationContext;
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("当前bean的名字："+name);
	}

	/**
	 * 用来解析字符串
	 * ${}
	 * 
	 * #{} Spring
	 */
	@Override
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		String resolveStringValue = resolver.resolveStringValue("当前的操作系统为:${os.name} 我是 #{20*18}");
		System.out.println("解析的字符串："+resolveStringValue);
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

}
