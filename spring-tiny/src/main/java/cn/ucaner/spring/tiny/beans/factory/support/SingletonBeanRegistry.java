/**
 * <html>
 * <body>
 *  <P> Copyright  JasonInternational </p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason. The Source On WebSite .  https://github.com/Jasonandy/Spring-Core </p>
 *  </body>
 * </html>
 */
package cn.ucaner.spring.tiny.beans.factory.support;

/**
* @Package：cn.ucaner.spring.tiny.beans.factory.support   
* @ClassName：SingletonBeanRegistry   
* @Description：   <p> SingletonBeanRegistry </p>
* @Author： - cwt    
* @CreatTime：2018年4月27日 下午6:11:18   
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public interface SingletonBeanRegistry {

	/**
	 * @Description: 在容器中创建一个指定的单例bean的类 
	 * <br>Register the given existing object as singleton in the bean registry,under the given bean name.
	 * @param beanName
	 * @param singletonObject void
	 * @Autor: Jason - Jasonandy@hotmail.com
	 */
    void registerSingleton(String beanName, Object singletonObject);

    /**
     * @Description: 返回一个singleton类
     * <br>Return the (raw) singleton object registered under the given name.
     * @param beanName
     * @return Object
     * @Autor: Jason - Jasonandy@hotmail.com
     */
    Object getSingleton(String beanName);

    /**
     * @Description: 判断容器红是否错在这个单例的bean
     * <br>Check if this registry contains a singleton instance with the given name.
     * @param beanName
     * @return boolean
     * @Autor: Jason - Jasonandy@hotmail.com
     */
    boolean containsSingleton(String beanName);

    /**
     * @Description: 统计单例Bean的个数
     * <br> Return the number of singleton beans registered in this registry.
     * @return int
     * @Autor: Jason - Jasonandy@hotmail.com
     */
    int getSingletonCount();
    
    
    /**
     * @Description: 返回这个单例bean的所有名字
     * @return String[]
     * @Autor: Jason - Jasonandy@hotmail.com
     */
    //String[] getSingletonNames();
    
    /**
     * @Description: getSingletonMutex 互斥锁
     * @return Object
     * @Autor:Jason - Jasonandy@hotmail.com
     */
    //Object getSingletonMutex();
}
