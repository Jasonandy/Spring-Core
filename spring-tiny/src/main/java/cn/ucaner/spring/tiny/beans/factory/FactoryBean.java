package cn.ucaner.spring.tiny.beans.factory;

/**
* @Package：cn.ucaner.spring.tiny.beans.factory   
* @ClassName：FactoryBean   
* @Description：   <p>FactoryBean  
* 
* 在Spring中，有两个很容易混淆的类：BeanFactory和FactoryBean
* BeanFactory：Bean工厂，是一个工厂(Factory)，我们Spring IoC容器的最顶层接口就是这个BeanFactory，它的作用是管理Bean，即实例化、定位、配置应用程序中的对象及建立这些对象间的依赖
* FactoryBean：工厂Bean，是一个Bean，作用是产生其他bean实例。通常情况下，这种bean没有什么特别的要求，仅需要提供一个工厂方法，该方法用来返回其他bean实例
* 
* 工厂Bean，用于产生其他对象
* 
* </p>
* @Author： - cwt   
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public interface FactoryBean<T> {
	
	/**
	 * @Description: Bean工厂创建的对象是否是单态模式，如果是单态模式，则整个容器中只有一个实例  对象，每次请求都返回同一个实例对象
	 * @return boolean
	 * @Autor: Jason - jasonandy@hotmail.com
	 */
	boolean  isSingleton();
	
	/**
	 * @Description: 获取容器管理的对象实例
	 * @return
	 * @throws Exception T
	 * @Autor: Jason - jasonandy@hotmail.com
	 */
    T getObject() throws Exception;

    /**
     * @Description: 获取Bean工厂创建的对象的类型 
     * @return Class<?>
     * @Autor: Jason - jasonandy@hotmail.com
     */
    Class<?> getObjectType();	
}
