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

/*
 * @author chenwentao
 * @since  2017-01-25
 */
//解析xml方法:返回BeanDefinition對象集合
//改写XmlParser，解析xml返回的应该是beandefinition，而不是直接就生成了bean
//在获取了beandefinition之后，在通过beandefinition创建bean

public class XmlParser {

    private static Map<String, BeanDefinition> beanDefinitions = new HashMap<>();
    private static List<String> ComponentPackageNames = new ArrayList<String>();
    private static Logger logger = LoggerFactory.getLogger(XmlParser.class);

    public final static Map<String, BeanDefinition> parser(Document doc) throws Exception {
        Element root = doc.getRootElement();// 获得根节点
        @SuppressWarnings("unchecked")
        List<Element> list = root.getChildren();
        for (Element elements : list) {
            BeanDefinition beanDefinition = new DefaultBeanDefinition();
            String PackageName = elements.getAttributeValue("packagename");
            if (PackageName != null) {
                ComponentPackageNames.add(PackageName);
            }
            // 获取属性值，即为对象的名字
            String beanDefinitonName = elements.getAttributeValue("id");
            if (beanDefinitonName == null) {
                continue;
            }
            // 在获取类的路径，在通过java反射获取类的类类型，在获取该类的对象
            String classpath = elements.getAttributeValue("class");
            Class<?> beanClass = null;
            if (classpath != null && beanDefinitonName != null) {
                beanClass = Class.forName(classpath);
                // 保存最初的对象
                beanDefinition.setBeanClass(beanClass);
            }
            // 获取子节点下的property节点
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
                    // 注入基本类型属性
                    if (beanDepend == null && value != null) {
                        //  先验证是否为空或者等于空串
                        if (Assert.isEffectiveString(proName) && Assert.isEffectiveString(type)) {
                            //思路：生成一个基本类型的bean，将其注入到bean容器(虽然可以实现，但是为每一个类的基本
                            //属性都需要生成一个bean，显然不合理)
                            //所以这样实现，如果是依赖于基本类型，那我给他一个特殊的依赖  name+type+value                    
                            beanDefinition.addDepend("."+proName+"+"+type+"+"+value);
                            //特殊的depend添加完成，我们将在DefaultListableBeanFactory的doCreateBean
                            //方法中进行处理
                        }

                    }
                    // 需要注入bean
                    if (beanDepend != null && value == null) {
                        // 在这里我直接让生成的beandefinied持有depends就可以，正真的注入发生在createBean 
                        beanDefinition.addDepend(beanDepend);
                    }
                    if ((beanDepend == null && value == null) || (beanDepend != null && value != null)) {
                        // 上个版本，如果bean创建顺序不对，则无法初始化bean
                        logger.error("请检查property元素配置的正确性，ref和value不能同时为空或者同时有值");
                        throw new XmlConfigurationErrorException("At XmlParser,请删除property元素或添加可用的属性值");
                    }
                }
            }
            beanDefinitions.put(beanDefinitonName, beanDefinition);
        }
        return beanDefinitions;
    }

    public static BeanDefinition getBeanDefinition(String name) {
        return beanDefinitions.get(name);
    }

    // 获取配置文件中的包名
    public static List<String> getComponentPackageNames() {
        return ComponentPackageNames;
    }
}
