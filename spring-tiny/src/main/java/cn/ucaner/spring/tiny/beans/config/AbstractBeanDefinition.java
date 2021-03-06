package cn.ucaner.spring.tiny.beans.config;

import java.util.ArrayList;
import java.util.List;

/**
* @Package：cn.ucaner.spring.tiny.beans.config   
* @ClassName：AbstractBeanDefinition   
* @Description：   <p> AbstractBeanDefinition
* 抽象类：基础bean-基石
* 
* 
* </p>
* @Author： - cwt   
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public abstract class AbstractBeanDefinition implements BeanDefinition {

	/**
	 * 默认scope值，bean的作用范围
	 */
    private final String SCOPE_DEFAULT = "single";
    
    /**
     * single 
     */
    private String scope = SCOPE_DEFAULT;
    
    private Object beanClass;

    /**
     * dependentBeanDefinitions 依赖的bean
     */
    List<String> dependentBeanDefinitions=new ArrayList<String>();

    /**
     * @param bean的作用域
     */
    @Override
    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public String getScope() {
        return this.scope;
    }

    @Override
    public boolean isSingleton() {
        return this.scope.equals(SCOPE_DEFAULT);
    }

    /**
     * 返回对bean定义的可读描述
     */
    @Override
    public String getDescription() {
        return null;
    }

    /**
     * 获取依赖的beanDefinition
     */
    @Override
    public List<String> getDepends() {
        return dependentBeanDefinitions;
    }

    /**
     *  添加beanDefinition依赖
     */
    @Override
    public void addDepend(String dependName) {
        dependentBeanDefinitions.add(dependName);
    }

    @Override
    public Class<?> getBeanClass() {
        Object beanClassObject = this.beanClass;
        if (beanClassObject == null) {
            throw new IllegalStateException("No bean class specified on bean definition");
        }
        if (!(beanClassObject instanceof Class)) {
            throw new IllegalStateException(
                    "Bean class name [" + beanClassObject + "] has not been resolved into an actual Class [Tiny Spring.]");
        }
        return (Class<?>) beanClassObject;
    }

    /**
     * Specify the class for this bean.(指定beandefiition的所持有的java对象的Class对象)
     */
    @Override
    public void setBeanClass(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

}
