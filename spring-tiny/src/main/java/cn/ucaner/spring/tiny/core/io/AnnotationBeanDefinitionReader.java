package cn.ucaner.spring.tiny.core.io;

import java.lang.reflect.Field;
import java.util.List;

import cn.ucaner.spring.tiny.beans.config.BeanDefinition;
import cn.ucaner.spring.tiny.beans.config.DefaultBeanDefinition;
import cn.ucaner.spring.tiny.beans.factory.support.BeanDefinitionRegistry;
import cn.ucaner.spring.tiny.beans.factory.support.XmlParser;
import cn.ucaner.spring.tiny.ioc.annotation.Autowired;
import cn.ucaner.spring.tiny.ioc.annotation.Component;
import cn.ucaner.spring.tiny.tools.Assert;
import cn.ucaner.spring.tiny.tools.PackageUtil;

/**
* @Package：cn.ucaner.spring.tiny.core.io   
* @ClassName：AnnotationBeanDefinitionReader   
* @Description：   <p> 直接继承XmlBeanDefinitionReader类实现，不仅能读取xml配置，
* 还能自动将注解类注入IOC容器
* 它从注解中获取beanDefinition
* </p>
* @Author： - cwt    
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public class AnnotationBeanDefinitionReader extends XmlBeanDefinitionReader {

    public AnnotationBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    @Override
    public int loadBeanDefinitions(Resource resource) throws Exception {
        return doLoadBeanDefinitionsFromAnnotation(resource);
    }

    /**
     * @Description: 扫描所有的包 
     * @return
     * @throws Exception int
     * @Autor: Jason - jasonandy@hotmail.com
     */
    public int loadBeanDefinitions() throws Exception {
        return doLoadBeanDefinitions(null);
    }

    /**
     * @Description: 通过注解生成beanDefinition 
     * @param resource
     * @return
     * @throws Exception int
     * @Autor: jason - jasonandy@hotmail.com
     */
    public int doLoadBeanDefinitionsFromAnnotation(Resource resource) throws Exception {
    	/**
    	 * 加载xml中定义的beanDefinition
    	 */
        int count = super.doLoadBeanDefinitions(resource);

        /**
         * 获得包名，将包下的类进行解析
         */
        List<String> PackageNames = XmlParser.getComponentPackageNames();
        
        /**
         * eg: cn.ucaner.aa....   扫描包下面的所有包
         */
        if (Assert.isNotEmpty(PackageNames)) {
            for (String PackageName : PackageNames) {
                /**
                 * 获取包下的所有类名
                 */
                List<String> ClassNames = PackageUtil.getClassName(PackageName);
                if (Assert.isNotEmpty(ClassNames)) {
                    for (String ClassName : ClassNames) {
                        BeanDefinition beanDefinition = new DefaultBeanDefinition();
                        /**
                         * 获得beanDefinition的beanClass
                         */
                        Class<?> beanClass = Class.forName(ClassName);
                        /**
                         * 验证是否有Component注解
                         */
                        Component com = beanClass.getAnnotation(Component.class);
                        
                        //component 注解
                        if (com != null) {
                            beanDefinition.setBeanClass(beanClass);
                            
                            /**
                             *  获取它的依赖
                             *  getFields()：获得某个类的所有的公共（public）的字段，包括父类中的字段。 
                             *  getDeclaredFields()：获得某个类的所有声明的字段，即包括public、private和proteced，但是不包括父类的申明字段
                             */
                            Field[] fields = beanClass.getDeclaredFields();
                            if (fields.length > 0) {
                                for (Field f : fields) {
                                    Autowired autowired = f.getAnnotation(Autowired.class);
                                    if (autowired != null) {
                                        beanDefinition.addDepend(autowired.value());
                                    }
                                }
                            }
                            
                            /**
                             * 默认使用全部小写的方式 注入到beanDefinition 
                             */
                            String beanDefinitionName =(ClassName.substring(ClassName.lastIndexOf(".") + 1)).toLowerCase();
                            beanDefinitions.put(beanDefinitionName, beanDefinition);
                            count++;
                        }//
                    }
                }
            }
        }
        return count;
    }
}
