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

    Logger logger = LoggerFactory.getLogger(this.getClass());

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
