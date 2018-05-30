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

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* @Package：cn.ucaner.spring.tiny.beans.factory.support   
* @ClassName：DefaultSingletonBeanRegistry   
* @Description：   <p> DefaultSingletonBeanRegistry </p>
* @Author： -    
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

	/**
	 * 获取日志记录器
	 */
    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * singletonObjects 单例bean容器 - ConcurrentHashMap 并发修改
     */
    private final Map<String, Object> singletonObjects = new ConcurrentHashMap<String, Object>(64);

    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    @Override
    public boolean containsSingleton(String beanName) {    
        return singletonObjects.containsKey(beanName);
    }

    @Override
    public int getSingletonCount() {
        return singletonObjects.size();
    }
}
