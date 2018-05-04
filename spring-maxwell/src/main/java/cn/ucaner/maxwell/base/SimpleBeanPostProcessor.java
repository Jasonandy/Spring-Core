package cn.ucaner.maxwell.base;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
* @Package：cn.ucaner.maxwell.base   
* @ClassName：SimpleBeanPostProcessor   
* @Description：   <p> SimpleBeanPostProcessor </p>
* @Author： - Jason    
* @CreatTime：2018年5月4日 上午10:43:43   
* @Modify By：   
* @ModifyTime：  2018年5月4日
* @Modify marker：   
* @version    V1.0
 */
public class SimpleBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }
}
