/**
 * <html>
 * <body>
 *  <P> Copyright  JasonInternational </p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason. The Source On WebSite .  https://github.com/Jasonandy/Spring-Core </p>
 *  </body>
 * </html>
 */
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
	
	int AUTOWIRE_NO = 0;//不使用自动装配 
	
    int AUTOWIRE_BY_NAME = 1;//通过名称自动装配 
    
    int AUTOWIRE_BY_TYPE = 2;//通过类型自动装配  
    
    int AUTOWIRE_CONSTRUCTOR = 3;//构造器装配 
    
    @Deprecated
    int AUTOWIRE_AUTODETECT = 4;//已过时  
    
    
	    
	//拥有自动注入bean的功能，检查Map集合，如果有@Autowire注解，进行自动注入
	 void AutowireBean();
}
