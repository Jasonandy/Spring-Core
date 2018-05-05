package cn.ucaner.spring.tiny.anntotion.handle;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.ucaner.spring.tiny.beans.factory.BeanFactory;
import cn.ucaner.spring.tiny.ioc.annotation.Autowired;

/**
* @Package：cn.ucaner.spring.tiny.anntotion.handle   
* @ClassName：AutowiredHandle   
* @Description：   <p> AutowiredHandle 
* 
* 注解处理器 
* 
* </p>
* @Author： - chenwentao   
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public class AutowiredHandle {
	
	
	
	/**
	 * logger 获取日志记录器
	 */
    private static Logger logger = LoggerFactory.getLogger(AutowiredHandle.class);

    /**
     * @Description: 对有注解了的类进行相关的处理
     * @param AutowiredClass 注解的类类型
     * @param beanFactory
     * @param beanName   带有@Autowired注解的类的名字
     * @throws Exception void
     * @Autor: Jason  - jasonandy@hotmail.com
     */
    public static void AutowiredHandleMethod(Class<?> AutowiredClass, BeanFactory beanFactory, String beanName) throws Exception {
       
    	//遍历AutowiredClass的方法 - 能拿到所有（不包括继承的方法）
        for (Method m : AutowiredClass.getDeclaredMethods()) {
            Autowired t = m.getAnnotation(Autowired.class);
            if (t != null) {
                String proName = t.value();
                Object bean = beanFactory.getBean(t.value());
                
                logger.debug("objectBean - {}",t.value() + bean);
                
                String methodName = "set" + proName.substring(0, 1).toUpperCase() + proName.substring(1);//setMethods()
               
                logger.debug("methodName - {}",methodName);
                
                Class<?> clz = beanFactory.getBean(beanName).getClass();
                // 通过反射获取方法
                Method method = clz.getMethod(methodName, bean.getClass());
                
                if (method != null) {
                    method.invoke(beanFactory.getBean(beanName), bean);
                } else {
                    logger.error("Call Method doesn't exist by Jason !  claz-name: {}",beanName);
                }
            }
        }
    }

}
