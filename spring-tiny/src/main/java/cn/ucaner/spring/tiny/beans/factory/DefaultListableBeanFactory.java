package cn.ucaner.spring.tiny.beans.factory;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.ucaner.spring.tiny.beans.config.BeanDefinition;
import cn.ucaner.spring.tiny.beans.factory.support.BeanDefinitionRegistry;
import cn.ucaner.spring.tiny.core.io.FileSystemResource;
import cn.ucaner.spring.tiny.core.io.Resource;
import cn.ucaner.spring.tiny.core.io.XmlBeanDefinitionReader;
import cn.ucaner.spring.tiny.enums.BasicType;
import cn.ucaner.spring.tiny.exception.CircularDependException;
import cn.ucaner.spring.tiny.exception.XmlConfigurationErrorException;

/**
* @Package：cn.ucaner.spring.tiny.beans.factory   
* @ClassName：DefaultListableBeanFactory   
* @Description：   <p> DefaultListableBeanFactory 
* 1.一個基本的容器实现,我這裡簡單實現，直接繼承AbstractBeanFactory
* 这个工厂和XmlBeanDefinitionReader是联系在一起的，当调用XmlBeanDefinitionReader类
* 中的loadBeanDefinitions()方法时，会调用registerBeanDefinition()方法，讲beandefinition
* 注入到DefaultListableBeanFactory，后面我在拓展工厂的时候，只需要继承DefaultListableBeanFactory
* 就拥有了完整的beandefinition集合
* 3.这里我们只能加载FileSystemResource，如需拓展，继承此类就可以
* </p>
* @Author： - chenwentao   
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public class DefaultListableBeanFactory extends AbstractBeanFactory implements BeanDefinitionRegistry, ResourceLoaderBeanFactory ,ListableBeanFactory{

    private static Logger logger = LoggerFactory.getLogger(DefaultListableBeanFactory.class);
    
    /**
     * beanDefinitionMap
     */
    protected Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>(256);
    
    /**
     * Resource
     */
    protected Resource resource;
    
    /**
     * static load log4j.cof
     */
    static {
        PropertyConfigurator.configure("log4j.properties");
    }

    /**
     * Ioc都是具有加载资源的能力的,所以给定两个基本的构造方法
     * 可以给工厂直接注入资源，当然也可以直接注入资源地址，因为它是具备资源加载的能力的
    * DefaultListableBeanFactory. 
    * @param resource 直接注入资源
    * @throws Exception
     */
    public DefaultListableBeanFactory(Resource resource) throws Exception {
        this.resource = resource;
        refresh();
    }

    /**
    * DefaultListableBeanFactory. 
    * @param location    直接注入资源地址
    * @throws Exception
     */
    public DefaultListableBeanFactory(String location) throws Exception {
        this.resource = getResource(location);
        refresh();
    }

    /**
    * @Package：cn.ucaner.spring.tiny.beans.factory   
    * @ClassName：ResourceReaderBeanFactory   
    * @Description：   <p> 资源的问题解决了，我们还得具备读取beandefinition的能力,
    * 本来是应该继承的容器中就具有了 读取的能力，这里为了简便，我们使用内部类实现</p>
    * @Author： - Jason   
    * @CreatTime：2018年5月30日 上午10:56:44   
    * @Modify By：   
    * @ModifyTime：  2018年5月30日
    * @Modify marker：   
    * @version    V1.0
     */
    protected class ResourceReaderBeanFactory extends XmlBeanDefinitionReader {
        public ResourceReaderBeanFactory(BeanDefinitionRegistry registry) {
            super(registry);
        }
    }

    /**
     * 在这里我们已经获取到了beanName and beanDefinition，只需将其注入到Map集合中就行了
     */
    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
    	logger.debug("[Tiny-Spring]注册beanMame-{},beanDefinition-{} By Jason.",beanName,beanDefinition);
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    /**
     * 移除beanDefinition by Name
     */
    @Override
    public void removeBeanDefinition(String beanName) {
        if (beanDefinitionMap.get(beanName) != null) {
            beanDefinitionMap.remove(beanName);
        } else {
        	logger.warn("[Tiny-Spring] Remove BeanDefinition By Name -{} not Find BeanDefinition.", beanName);
        }
    }

    /**
     * File Path get Resource
     */
    @Override
    public Resource getResource(String location) {
        return new FileSystemResource(location);
    }

    /**
     * @Description: refresh init
     * @throws Exception void
     * @Autor: Jason - Jasonandy@hotmail.com
     */
    protected void refresh() throws Exception {

    	/**
    	 * 在这里，我们完成容器的初始化
    	 * One.资源我们已经在构造方法中获取
    	 * Two.资源的解析
    	 * Three.容器的注册方法会被自动调用，此时注册就完成了
    	 */
        int count = new ResourceReaderBeanFactory(this).loadBeanDefinitions(resource);
        logger.info("[Tiny-Spring] All Register beanDefinition Numbers count- {} - By JASON[加载成功] ",count);
    }

    
    /**
     * Tiny-Spring Core CreateBean by beanName and beanDefinition 
     * 如何通过beanDefinition获得一个完整的bean实例（我们已经获取了bean的依赖集合）
     * 反射获取方法，进行bean的注入
     */
    @Override
    protected Object createBean(String beanNmae, BeanDefinition beanDefinition) throws CircularDependException {

    	List<String> depends = beanDefinition.getDepends();
        Class<?> claz = beanDefinition.getBeanClass();
        Object bean = null;
        try {
            //通过反射生成bean的实例
            bean = claz.newInstance();
        } catch (Exception e) {
        	logger.error("[Tiny-Spring]Reflect exception clazName-{} [反射失败]",claz);
        }
        
        /**
         * Bean依赖其他bean 需要注入
         */
        if (depends != null && depends.size() >= 1) {
        	/**
        	 * 此时的bean还不完整，还没有注入它的依赖，我们将它放入新生池
        	 */
            babyBeanPool.put(beanNmae, bean);
            for (String depend : depends) {
                if (babyBeanPool.get(depend) != null) {
                	logger.error("[Tiny-Spring] beanDefinition 已经存在依赖关系,has exist in babyBeanPool.");
                    throw new CircularDependException();
                }
                /**
                 * 在这里分两种情况，先确定需要注入的是基本类型还是bean
                 */
                if (isBaiscType(depend)) {//基本类型
                    try {
                        bean = beanBasicTypeAutowired(bean, depend);
                    } catch (Exception e) {
                        // 不做任何处理
                    }
                } else {
                	
                	/**
                	 * set 反射注入Bean 获取bean的class对象 通过反射获取方法
                	 */
                    String methodName = "set" + depend.substring(0, 1).toUpperCase() + depend.substring(1);
                    try {
                    	//setBean( clazz )
                        Method method = claz.getMethod(methodName, completedBeanPool.get(depend).getClass());
                        // 调用set方法完成注入
                        method.invoke(bean, completedBeanPool.get(depend));
                    } catch (NoSuchMethodException e) {
                    	logger.error("[Tiny-Spring]需要获取得bean中没有ModthodName-{}方法.",methodName);
                    } catch (Exception e) {
                    	logger.error("[Tiny-Spring]获取到了Setter:{}方法,没有能获取到需要注入的Bean:{}.",methodName,depend);
                    }
                }

            }
        }
        return bean;
    }

    /**
     * 通过name获取beanDefinition
     */
    @Override
    public BeanDefinition getBeanDefinition(String beanDefinitionName) {
        return beanDefinitionMap.get(beanDefinitionName);
    }

    /**
     * IS  HAS Contains BeanDefinition . 
     */
    @Override
    public boolean containsBeanDefintion(String beanDefinitionName) {
        return beanDefinitionMap.get(beanDefinitionName) != null;
    }

    /**
     * @Description: 注入的时候已经定义好格式  - 可以自定义    .claz.type.method
     * @param depend
     * @return boolean
     * @Autor: Jason - JASONANDY@HOTMAIL.COM
     */
    private boolean isBaiscType(String depend) {
        return depend.charAt(0) == '.';
    }

    private Object invokeMethod(Object bean, String methodName, Class<?> parameterTypes, Object args) {
        try {
            Method method = bean.getClass().getMethod(methodName, parameterTypes);
            method.invoke(bean, args);
        } catch (Exception e) {
        	logger.error("基本类型注入时方法调用错误，可能原因：属性名配置错误，类型不匹配\n"+"方法名："+methodName+"参数："+args);
        }
        return null;
    }

    
    /**
     * @Description: 注入基本类型数据
     * @param bean   bean
     * @param depend depend
     * @return Object
     * @throws XmlConfigurationErrorException Object
     * @Autor: Jason - Jasonandy@hotmail.com
     */
    private Object beanBasicTypeAutowired(Object bean, String depend) throws XmlConfigurationErrorException {
        // 将字符串进行分割解析 name+type+value
        String realDepend = depend.substring(1);
        String[] values = realDepend.split("\\+");
        String name = values[0];
        String type = values[1];
        String value = values[2];
        // 我先需要先创建一个基本类型的对象 
        String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
        try {
            Class<?> typeClss = Class.forName(type);
            String typeName = typeClss.getSimpleName();
            if (typeName.equals(BasicType.Boolean.simpleTypeName)) {
                if (Objects.equals(value, "true") || Objects.equals(value, "1")) {
                    Boolean bool = true;
                    invokeMethod(bean, methodName, Boolean.class, bool);
                } else if (Objects.equals(value, "false") || Objects.equals(value, "0")) {
                    Boolean bool = false;
                    invokeMethod(bean, methodName, Boolean.class, bool);
                } else {
                    throw new XmlConfigurationErrorException("xml配置的属性值和其类型不匹配！");
                }
            } else if (typeName.equals(BasicType.String.simpleTypeName)) {
                String str = value;
                invokeMethod(bean, methodName, String.class, str);
            } else if (typeName.equals(BasicType.Long.simpleTypeName)) {
                Long l = Long.parseLong(value);
                invokeMethod(bean, methodName, Long.class, l);
            } else if (typeName.equals(BasicType.Character.simpleTypeName)) {
                // 先判断下value的长度
                if (value.length() > 1) {
                    throw new XmlConfigurationErrorException("xml配置的属性值和其类型不匹配！");
                }
                char ch = value.charAt(0);
                invokeMethod(bean, methodName, Character.class, ch);
            } else if (typeName.equals(BasicType.Integer.simpleTypeName)) {
                Integer i = Integer.parseInt(value);
                invokeMethod(bean, methodName, Integer.class, i);
            } else if (typeName.equals(BasicType.Byte.simpleTypeName)) {
                Byte b = value.getBytes()[0];
                invokeMethod(bean, methodName, Byte.class, b);
            } else if (typeName.equals(BasicType.Float.simpleTypeName)) {
                Float f = Float.parseFloat(value);
                invokeMethod(bean, methodName, Float.class, f);
            } else if (typeName.equals(BasicType.Double.simpleTypeName)) {
                Double d = Double.parseDouble(value);
                invokeMethod(bean, methodName, Double.class, d);
            } else {
                throw new XmlConfigurationErrorException("beanName：" + bean.getClass().getSimpleName() + "的类型配置错误");
            }
        } catch (ClassNotFoundException e) {
        	logger.error("错误的基本类型：" + type);
        }
        return bean;
    }

	@Override
	public ClassLoader getClassLoader() {
		return null;
	}
}
