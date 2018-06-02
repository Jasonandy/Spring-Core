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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.ucaner.spring.tiny.beans.config.BeanDefinition;
import cn.ucaner.spring.tiny.beans.factory.support.DefaultSingletonBeanRegistry;
import cn.ucaner.spring.tiny.exception.BeansException;
import cn.ucaner.spring.tiny.exception.CircularDependException;
import cn.ucaner.spring.tiny.exception.NoSuchBeanDefinitionException;

/**
* @Package：cn.ucaner.spring.tiny.beans.factory   
* @ClassName：AbstractBeanFactory   
* @Description：   <p> AbstractBeanFactory </p>
* @Author： - chenwentao   
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    private Logger logger = LoggerFactory.getLogger(AbstractBeanFactory.class);

    /**
     * 已经完成创建的bean - 创建完成bean池，我会将创建已完成的bean放入其中
     */
    protected Map<String, Object> completedBeanPool = new HashMap<String, Object>();

    /**
     * 有相关依赖还没有创建的bean - 创建bean新生池，将正在创建的bean放入其中
     */
    protected Map<String, Object> babyBeanPool = new HashMap<String, Object>();

    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, Object.class);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return doGetBean(name, requiredType);
    }

    // 获得bean的实例
    @SuppressWarnings("unchecked")
    protected <T> T doGetBean(String name, Class<T> requiredType) throws BeansException {
    	/**
    	 * 将当前需要创建的bean放入新生池
    	 */
        babyBeanPool.put(name, requiredType);
        Object bean;
        /**
         * 首先我们急切的去单例池里面去找,如果单例池里面有
         */
        if ((bean = getSingleton(name)) != null) {
        	/**
        	 * 如果传入的requiredType==null || 不是所要求类型的实例
        	 */
            if (requiredType == null || !requiredType.isInstance(bean)) {
                logger.error("[Tiny-Spring]传入的requiredType==null || 不是所要求类型的实例 .");
                
                throw new ClassCastException("[Tiny-Spring]Convert Type Exception.");
            }
        } else {
            // 获得beanDefinition
            BeanDefinition beanDefinition = getBeanDefinition(name);
            if (beanDefinition == null)
                try {
                    throw new NoSuchBeanDefinitionException("");
                } catch (NoSuchBeanDefinitionException e1) {
                    logger.error("[Tiny-Spring] Bean doesn't exist NAMED-{}",name);
                    return null;
                }
            
            /**
             * 在创建bean之前，我先得将它依赖的bean进行创建 1.获取beanDefintionName
             */
            List<String> depends = beanDefinition.getDepends();

            /**
             * if create bean has deppend other bean .
             */
            if (depends != null && depends.size() >= 1) {
                for (String depend : depends) {
                	/**
                	 * 如果依赖的是基本类型，则不需要先进行创建
                	 * Not Bean Object  . continue .
                	 */
                    if(depend.indexOf('.')==0){
                        continue;
                    }
                    if (!containsBeanDefintion(depend)) {
                    	/**
                    	 * 如果发现该bean的某些依赖不存在
                    	 * 直接跳过，进入下一次循环
                    	 */
                        logger.warn("[Tiny-Spring] Maybe you Create Bean:{} 's depends:{} is doesn't exist ",name,depend);
                        continue;
                    } else {
                    	/**
                    	 * 存在该bean依赖的beanDefinition，我们必须先创建它所依赖的bean
                    	 * 在这里，如果发现需要的依赖bean并没有创建完毕
                    	 */
                        if (babyBeanPool.get(depend) != null) {
                            logger.error("[Tiny-Spring]Please Check You config Beacuse Content Has exist This BeanDefinition :{}",depend);
                            throw new CircularDependException();
                        }
                        getBean(depend);
                    }
                }
            }
            /**
             * Bean 初始化完成.
             */
            bean = createBean(name, beanDefinition);
            /**
             * 放入完成池,并将它移除新生池
             */
            addToCompletedBeanPoolAndRemoveFromBabyBeanPool(name, bean);
        }
        return (T) bean;
    }

    /**
     * @Description: 将创建完成的bean放入完成池,并将它移除新生池
     * @param name
     * @param bean void
     * @Autor: jason - jasonandy@hotail.com
     */
    private synchronized void addToCompletedBeanPoolAndRemoveFromBabyBeanPool(String name, Object bean) {
        if (completedBeanPool.get(name) == null) {
            completedBeanPool.put(name, bean);
        }
        babyBeanPool.remove(name);
    }

    @Override
    public boolean isSingleton(String beanDefinitionName) throws NoSuchBeanDefinitionException {
        if (!containsBeanDefintion(beanDefinitionName)) {
            throw new NoSuchBeanDefinitionException("[Tiny-Spring] Context does not exist This BeanDefinition.");
        } else {
            return getBeanDefinition(beanDefinitionName).isSingleton();
        }
    }

    /**
     * @Description: Create a bean instance for the given merged(混合的，模糊的) bean definition (and arguments)
     * 我这里不再需要给出参数值，基本类型的属性会在xmlparse解析的时候进行注入， 我这里的createBean 只处理bean之间的依赖关系
     * @param BeanName
     * @param beanDefinition
     * @return
     * @throws CircularDependException Object
     * @Autor: Jason - jasonandy@hotmail.com
     */
    protected abstract Object createBean(String BeanName, BeanDefinition beanDefinition) throws CircularDependException;

}
