package cn.ucaner.spring.tiny.beans.factory;

/**
* @Package：cn.ucaner.spring.tiny.beans.factory   
* @ClassName：AutowireCapableBeanFactory   
* @Description：   <p> 带有自动注入功能的beanfactory </p>
* @Author： - chenwentao   
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public interface AutowireCapableBeanFactory extends BeanFactory{
	
	//拥有自动注入bean的功能，检查Map集合，如果有@Autowire注解，进行自动注入
	 void AutowireBean();
}
