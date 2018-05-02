package cn.ucaner.spring.tiny.beans.factory;

/**
* @Package：cn.ucaner.spring.tiny.beans.factory   
* @ClassName：ListableBeanFactory   
* @Description：   <p> 拓展了一些beanfactory的功能：
* 	主要是关于BeanDefinition的信息：获取BeanDefinition，获取bean的类型信息，不同\
* 	方式获取bean的名字
* 
* BeanFactory接口的扩展，被能够一次性列举所有它们bean实例，而不是试图根据客户端请求一个一个的通过名字查找的的工厂容器实现。
* 那些需要预先加载所有bean定义的工厂需要实现这个接口。
* 
* 
* 这个接口中的方法仅仅关注此工厂内部的bean定义。
* 它们会忽略任何被像ConfigurableBeanFactory的registerSingleton方法已注册的单例的bean，getBeanNamesOfType和getBeansOfType例处，但也会手动的检查已被注册的单例bean。
* 当然，BeanFactory的getBean方法也可以透明的访问这些特殊的bean（已被注册的单例bean）.
* 然而，在经典的场合，无论如何，所有bean都会被处部定义 定义，所以许多程序不需要这方面不同
* 
* 
* 注意：除了getBeanDefinitionCount和containsBeanDefinition，这个接口中的方法没有被当作频繁调用的方法设计，实现可以会慢。
* </p>
* @Author： -    
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public interface ListableBeanFactory extends BeanFactory{
	
	 /**
     * 检查这个BeanFactory是否包含给定名字的的bean定义。
     * 不考虑这个工厂参与的任何层级关系，
     * 忽略不是bean定义的所有通过其他方式注册的单例bean
     */
   // boolean containsBeanDefinition(String beanName);
	
	/**
     * 返回在此工厂中定义的bean数量。
     * 不考虑这个工厂参与的任何层级关系，
     * 忽略不是bean定义的所有通过其他方式注册的单例bean
     */
   // int getBeanDefinitionCount();
	
	
	 /**
     * 返回此工厂中定义的所有bean的名字。
     * 不考虑此工厂参与的所有层次关系，
     * 忽略不是bean定义的所有通过其他方式注册的单例bean
     * 如果此工厂没有bean定义，返回一个空的数组。
     */
   // String[] getBeanDefinitionNames();
	
}
