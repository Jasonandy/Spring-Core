package cn.ucaner.maxwell.base;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
* @Package：cn.ucaner.maxwell.base   
* @ClassName：SimpleBeanFactoryPostProcessor   
* @Description：   <p> SimpleBeanFactoryPostProcessor </p>
* @Author： - Jason    
* @CreatTime：2018年5月4日 上午10:43:32   
* @Modify By：   
* @ModifyTime：  2018年5月4日
* @Modify marker：   
* @version    V1.0
 */
@Configurable
public class SimpleBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {
		SimpleBean bean = beanFactory.getBean(SimpleBean.class);
		bean.getStudent().setName("^_^");
	}
	
}
