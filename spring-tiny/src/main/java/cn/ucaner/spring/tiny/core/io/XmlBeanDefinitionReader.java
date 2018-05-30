package cn.ucaner.spring.tiny.core.io;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.jdom.Document;

import cn.ucaner.spring.tiny.beans.config.BeanDefinition;
import cn.ucaner.spring.tiny.beans.config.DefaultBeanDefinition;
import cn.ucaner.spring.tiny.beans.factory.support.BeanDefinitionRegistry;
import cn.ucaner.spring.tiny.beans.factory.support.XmlParser;

/**
* @Package：cn.ucaner.spring.tiny.core.io   
* @ClassName：XmlBeanDefinitionReader   
* @Description：   <p> XmlBeanDefinitionReader </p>
* @Author： -    
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

	/**
	 * 暂时保存beanDefinition，稍后在doLoadBeanDefinitions方法中注册到beanFactory
	 */
    protected Map<String, BeanDefinition> beanDefinitions = new HashMap<String, BeanDefinition>();

    /**
     * 默認使用DefaultBeanDefinition
     * 本來是應該講這個beanDefinition對象傳遞給xmlparser，在這裡先簡單實現
     */
    @SuppressWarnings("unused")
    private BeanDefinition beanDefinition;

    
    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
        beanDefinition = new DefaultBeanDefinition();
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, BeanDefinition beanDefinition) {
        super(registry);
        this.beanDefinition = beanDefinition;
    }

    /**
     * Spring 有四种加载Bean的方式  此处实现一种
     */
    @Override
    public int loadBeanDefinitions(Resource resource) throws Exception {
        return doLoadBeanDefinitions(resource);
    }

    /**
     * @Description: doLoadBeanDefinitions 
     * @param resource
     * @return
     * @throws Exception int
     * @Autor: Jason - Jasonandy@hotmail.com
     */
    public int doLoadBeanDefinitions(Resource resource) throws Exception {
    	
    	/**
    	 * 加载beanDefinition GetXml Document
    	 */
        Document doc = doLoadDocument(resource);

        /**
         * 解析Document
         */
        beanDefinitions = XmlParser.parser(doc);
        
        /**
         * 再次可以选择注入一个什么类型的Bean
         */
        for (Entry<String, BeanDefinition> beanDefinition : beanDefinitions.entrySet()) {
        	/**
        	 * key is the name of bean,value is the beanDefinition
        	 */
            registry.registerBeanDefinition(beanDefinition.getKey(), beanDefinition.getValue());
        }
        return beanDefinitions.size();
    }

    protected Document doLoadDocument(Resource resource) throws Exception {
        return new XmlDocumentResource(resource.getFile()).getDocument();
    }

}
