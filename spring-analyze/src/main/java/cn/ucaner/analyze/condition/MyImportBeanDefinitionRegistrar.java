package cn.ucaner.analyze.condition;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import cn.ucaner.analyze.bean.RainBow;

/**
* @Package：cn.ucaner.analyze.condition   
* @ClassName：MyImportBeanDefinitionRegistrar   
* @Description：   <p> 可以用来做判断 - 是否注册的逻辑</p>
* @Author： - Jason   
* @CreatTime：2018年9月14日 下午12:33:00   
* @Modify By：   
* @ModifyTime：  2018年9月14日
* @Modify marker：   
* @version    V1.0
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	/**
	 * AnnotationMetadata：当前类的注解信息
	 * BeanDefinitionRegistry:BeanDefinition注册类；
	 * 		把所有需要添加到容器中的bean；调用
	 * 		BeanDefinitionRegistry.registerBeanDefinition手工注册进来
	 */
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		
		boolean definition = registry.containsBeanDefinition("cn.ucaner.analyze.bean.Red");
		boolean definition2 = registry.containsBeanDefinition("cn.ucaner.analyze.bean.Blue");
		if(definition && definition2){
			//指定Bean定义信息；（Bean的类型，Bean。。。）
			RootBeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
			//注册一个Bean，指定bean名
			registry.registerBeanDefinition("rainBow", beanDefinition);
		}
	}

}
