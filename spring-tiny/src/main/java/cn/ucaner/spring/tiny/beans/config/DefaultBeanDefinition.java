package cn.ucaner.spring.tiny.beans.config;

/*
 * @author chenwentao
 * @since  2017-01-25
 */
public class DefaultBeanDefinition extends AbstractBeanDefinition {

    @Override
    public String getDescription() {
        return getBeanClass().getName();
    }

    public DefaultBeanDefinition() {

    }

}
