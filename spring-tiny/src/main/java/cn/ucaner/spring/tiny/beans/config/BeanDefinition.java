package cn.ucaner.spring.tiny.beans.config;

import java.util.List;

import cn.ucaner.spring.tiny.enums.ConfigurableBeanFactory;

/**
* @Package：cn.ucaner.spring.tiny.beans.config   
* @ClassName：BeanDefinition   
* @Description：   <p> 
* 思考：如何实现bean创建顺序的问题？被依赖的bean先创建，我这里的实现方式已经脱离了原来的
* spring，spring 在beandefinition中有一个String[] getDependsOn()的方法，可以返回依赖bean
* 的name,我在这里采用持有的方式实现bean创建顺序的问题，借鉴组合模式的思想，一个bean，它可以依赖
* 含有其他的bean，也可以是一个独立的bean。好，那么我让beandefinition具有持有其他beandefinition的能力
* 
* 注：在我模拟spring的过程中，我直接采用beandefinition直接持有java对象的方式实现
* spring是通过beandefinition来createbean，依赖注入的触发发生在AbstractBeanFactory 
* 的doGetBean方法里面，createBean发生在AbstractAutowireCapableBeanFactory的doCreateBean里面
* 
* [Tips]
* SpringIOC容器管理了我们定义的各种Bean对象及其相互的关系，Bean对象在Spring实现中是以BeanDefinition来描述的
* 
* IoC容器的初始化包括BeanDefinition的Resource定位、载入和注册这三个基本的过程.
* 
* 抽象数据结构 - 属性参数，构造器参数，以及其他具体的参数
* </p>
* @Author： - chenwentao   
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public interface BeanDefinition {

	/**
	 * 单例或原型
	 */
    String SCOPE_SINGLETON = ConfigurableBeanFactory.SCOPE_SINGLETON.getBeanScope();
    String SCOPE_PROTOTYPE = ConfigurableBeanFactory.SCOPE_PROTOTYPE.getBeanScope();

    //获得依赖BeanDefinition的名字
    List<String> getDepends();

    void addDepend(String depend);

    String getScope();

    void setScope(String scope);

    boolean isSingleton();

    String getDescription();

    Class<?> getBeanClass();

    void setBeanClass(Class<?> beanClass);
}
