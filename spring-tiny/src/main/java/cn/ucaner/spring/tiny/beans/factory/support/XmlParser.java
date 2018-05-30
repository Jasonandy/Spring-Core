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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.ucaner.spring.tiny.beans.config.BeanDefinition;
import cn.ucaner.spring.tiny.beans.config.DefaultBeanDefinition;
import cn.ucaner.spring.tiny.exception.XmlConfigurationErrorException;
import cn.ucaner.spring.tiny.tools.Assert;

/**
* @Package：cn.ucaner.spring.tiny.beans.factory.support   
* @ClassName：XmlParser   
* @Description：   <p> 
* 解析xml方法:返回BeanDefinition對象集合
* 改写XmlParser，解析xml返回的应该是beandefinition，而不是直接就生成了bean
* 在获取了beandefinition之后，在通过beandefinition创建bean
* 
* 
* 读取xml封装成每一个beanDefinition 然后Factory根据beanDefinition创建对应的bean 默认用的为单例
* 
* </p>
* @Author： - AbstractBeanFactory   
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public class XmlParser {
	
	/** 
	 * slf4j 获取日志记录器 synchronized 对象锁.
	 */
	 private static Logger logger = LoggerFactory.getLogger(XmlParser.class);
	
	/**
	 *将解析到的XML的所有beanDefintion存入Map容器 
	 */
    private static Map<String, BeanDefinition> beanDefinitions = new HashMap<String, BeanDefinition>();
    
    /**
     * 组件包名 
     */
    private static List<String> componentPackageNames = new ArrayList<String>();
    
    /**
     * @Description: Parser Xml File.
     * @param doc   xml Document 
     * @return
     * @throws Exception Map<String,BeanDefinition>
     * @Autor: Jason - JasonAndy@hotmail.com
     */
    public final static Map<String, BeanDefinition> parser(Document doc) throws Exception {
        Element root = doc.getRootElement();// 获得根节点
        @SuppressWarnings("unchecked")
        List<Element> list = root.getChildren();
        for (Element elements : list) {
            BeanDefinition beanDefinition = new DefaultBeanDefinition();
            /**
             * eg:<package-scan packagename="cn.ucaner.spring.tiny.bean"></package-scan>
             * result:  packagename = cn.ucaner.spring.tiny.bean... 
             */
            String PackageName = elements.getAttributeValue("packagename");
            if (PackageName != null) {
            	/**
            	 * 组件包名 SpEl  方便扫包注入?
            	 */
            	componentPackageNames.add(PackageName);
            }
            
            /**
             * 获取属性值，即为对象的名字
             * eg:  <bean id="aspectbeana" class="cn.ucaner.spring.tiny.core.aop.AspectJBeanA"></bean>
             */
            String beanDefinitonName = elements.getAttributeValue("id");
            
            if (beanDefinitonName == null) {
                continue;
            }
            
            /**
             * 在获取类的路径，在通过java反射获取类的类类型，在获取该类的对象
             * eg:  <bean id="aspectbeana" class="cn.ucaner.spring.tiny.core.aop.AspectJBeanA"></bean>
             */
            String classpath = elements.getAttributeValue("class");
            
            Class<?> beanClass = null;
            if (classpath != null && beanDefinitonName != null) {
            	//Class.forName 反射获取class 类型 
                beanClass = Class.forName(classpath);
                
                // 保存最初的对象 Class<?> class  类的对象
                beanDefinition.setBeanClass(beanClass);
            }
            
            /**
             * 获取子节点下的property节点
             * <bean id="people" class="cn.ucaner.spring.tiny.classForTest.People">
		     *      <property ref="food" > </property>
		     * </bean>
		     * 
		     * property:属性 
		     * 
		     * name:
		     * 
		     * ...
             */
            @SuppressWarnings("unchecked")
            List<Element> eles = elements.getChildren("property");
            if (eles != null && eles.size() >= 1) {
                // 进行遍历
                for (Element e : eles) {
                    // 属性名
                    String proName = e.getAttributeValue("name");
                    // bean
                    String beanDepend = e.getAttributeValue("ref");
                    // 需要注入的基本类型值
                    String value = e.getAttributeValue("value");
                    // 需要注入的基本类型的类型
                    String type = e.getAttributeValue("type");
                    
                    /**
                     * 没有依赖其他的Bean 
                     * 故只有注入对应的属性ok
                     */
                    if (beanDepend == null && value != null) {
                    	/**
                    	 * 先验证是否为空或者等于空串
                    	 */
                        if (Assert.isEffectiveString(proName) && Assert.isEffectiveString(type)) {
                        	/**
                        	 * 思路：生成一个基本类型的bean，将其注入到bean容器(虽然可以实现，但是为每一个类的基本属性都需要生成一个bean，显然不合理)
                        	 * 所以这样实现，如果是依赖于基本类型，那我给他一个特殊的依赖  name+type+value 
                        	 */
                            beanDefinition.addDepend("."+proName+"+"+type+"+"+value);
                            /**
                             * 特殊的depend添加完成，我们将在DefaultListableBeanFactory的doCreateBean 方法中进行处理
                             */
                        }

                    }
                    
                    /**
                     * 有依赖的先关bean需要注入
                     */
                    if (beanDepend != null && value == null) {
                    	
                    	/**
                    	 * ref ? not value?
                    	 * 在这里我直接让生成的beandefinied持有depends就可以，正真的注入发生在createBean 
                    	 */
                        beanDefinition.addDepend(beanDepend);
                    }
                    if ((beanDepend == null && value == null) || (beanDepend != null && value != null)) {
                    	
                    	/**
                    	 * 上个版本，如果bean创建顺序不对，则无法初始化bean
                    	 * 
                    	 * 同时不存在   or 不同时为Null
                    	 */
                        logger.error("[Tiny-Spring] Please check property element config is Correct . ref和value不能同时为空或者同时有值");
                        
                        throw new XmlConfigurationErrorException("[Tiny-Spring] Xml conf error . 请删除property元素或添加可用的属性值!");
                    }
                }
            }
            
            //beanDefinitionsMap put beanDefinition  Just For Get
            beanDefinitions.put(beanDefinitonName, beanDefinition);
        }
        return beanDefinitions;
    }

    /**
     * @Description: GetClass  DeanDefinition .
     * @param name   Class. name
     * @return BeanDefinition
     * @Autor: Jason - Jasonandy@hotmail.com
     */
    public static BeanDefinition getBeanDefinition(String name) {
    	logger.debug("[Tiny-Spring] Start getBeanDefinition By ClazzName-{}",name);
        return beanDefinitions.get(name);
    }

    /**
     * @Description: 获取配置文件中的包名 
     * @return List<String>
     * @Autor: Jason - Jasonandy@hotmail.com
     */
    public static List<String> getComponentPackageNames() {
        return componentPackageNames;
    }
}
