package cn.ucaner.spring.tiny.beans.factory;

import cn.ucaner.spring.tiny.beans.config.BeanDefinition;
import cn.ucaner.spring.tiny.exception.BeansException;
import cn.ucaner.spring.tiny.exception.NoSuchBeanDefinitionException;

/**
* @Package：cn.ucaner.spring.tiny.beans.factory   
* @ClassName：BeanFactory   
* @Description：   <p> 定义容器的基本雏形 BeanFactory作为最顶层的一个接口类 
* BeanFactory 有三个子类：ListableBeanFactory、HierarchicalBeanFactory 和 AutowireCapableBeanFactory
* 
* 最终默认实现是的子类是： DefaultListableBeanFactory 
* 
* ListableBeanFactory  表示Bean是可列表的
* 
* HierarchicalBeanFactory  表示bean是有继承关系的,也就是每个bean可能有父bean
* 
* AutowireCapableBeanFactory 接口定义 Bean 的自动装配规则 
* 
* 四个接口共同定义了 Bean 的集合 Bean 之间的关系 以及 Bean 行为
* 
* 
* BeanFactory里只对IOC容器的基本行为作了定义 具体的工厂怎么去实现是不关心的
* 
* 
* 要知道工厂是如何产生对象的，我们需要看具体的IOC容器实现，spring提供了许多IOC容器的实现。
* 比如XmlBeanFactory,ClasspathXmlApplicationContext等...
* 
* 其中XmlBeanFactory就是针对最基本的IOC容器的实现，这个IOC容器可以读取XML文件定义的BeanDefinition（XML文件中对bean的描述）,
* 如果说XmlBeanFactory是容器中的屌丝,ApplicationContext应该算容器中的高帅富.
* 
* </p>
* @Author： - chenwentao    
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public interface BeanFactory {
	
	
	/**
	 * 对FactoryBean的转义定义，因为如果使用bean的名字检索FactoryBean得到的对象是工厂生成的对象，如果需要得到工厂本身，需要转义        	
	 */
     String FACTORY_BEAN_PREFIX = "&"; 
    
	 /**
	  * @Description:根据bean的名字，获取在IOC容器中得到bean实例   
	  * @param name  驼峰命名规则
	  * @return bean Object 
	  * @throws BeansException Object
	  * @Autor: Jason - jasonandy@hotmail.com
	  */
	 Object getBean(String name) throws BeansException;
	 
	 /**
	  * @Description: 根据bean的名字和Class类型来得到bean实例，增加了类型安全验证机制。    
	  * @param name bean的名字
	  * @param requiredType Class类型
	  * @return bean Object 
	  * @throws BeansException T
	  * @Autor: Jason - jasonandy@hotmail.com
	  */
	 <T> T getBean(String name,Class <T> requiredType) throws BeansException;
	 
	 /**
	  * @Description: 提供对bean的检索，看看是否在IOC容器有这个名字的bean  
	  * @param beanDefinitionName
	  * @return boolean
	  * @Autor: Jason - jasonandy@hotmail.com 
	  */
	 boolean containsBeanDefintion(String beanDefinitionName);
	 
	 /**
	  * @Description: 根据bean名字得到bean实例，并同时判断这个bean是不是单例 
	  * @param beanDefinitionName
	  * @return
	  * @throws NoSuchBeanDefinitionException boolean
	  * @Autor:  Jason - jasonandy@hotmail.com 
	  */
	 boolean isSingleton(String beanDefinitionName) throws NoSuchBeanDefinitionException;
	 
	 /**
	  * @Description: BeanDefinition 
	  * @param beanDefinitionName
	  * @return BeanDefinition
	  * @Autor:  Jason - jasonandy@hotmail.com 
	  */
	 BeanDefinition getBeanDefinition(String beanDefinitionName);
	 
	 /**
	  * @Description: 得到bean实例的Class类型 
	  * @param name
	  * @return
	  * @throws NoSuchBeanDefinitionException Class<?>
	  * @Autor:  Jason - jasonandy@hotmail.com 
	  */
	// Class<?> getType(String name) throws NoSuchBeanDefinitionException; 
	 
	/**
	 * @Description: 得到bean的别名，如果根据别名检索，那么其原名也会被检索出来 
	 * @param name
	 * @return String[]
	 * @Autor: Jason - jasonandy@hotmail.com
	 */
	 //String[] getAliases(String name);
}
