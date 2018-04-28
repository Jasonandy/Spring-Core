package cn.ucaner.spring.tiny.beans.factory;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.ucaner.spring.tiny.bean.BeanA;
import cn.ucaner.spring.tiny.classForTest.Food;
import cn.ucaner.spring.tiny.classForTest.People;
import cn.ucaner.spring.tiny.core.io.FileSystemResource;
import cn.ucaner.spring.tiny.exception.BeansException;

/**
* @Package：cn.ucaner.spring.tiny.beans.factory   
* @ClassName：DefaultListableBeanFactoryTest   
* @Description：   <p> DefaultListableBeanFactoryTest </p>
* @Author： -    
* @Modify By：   
* @ModifyTime：  2018年4月28日
* @Modify marker：   
* @version    V1.0
 */
public class DefaultListableBeanFactoryTest {

    private static Logger log = LoggerFactory.getLogger(DefaultListableBeanFactory.class);
    
    DefaultListableBeanFactory defaultListableBeanFactory;
    
    static {
        PropertyConfigurator.configure("classpath:/test/resource/log4j.properties");
    }

    @Before
    public void testDefaultListableBeanFactoryResource() {
        // 注入一个resource
        FileSystemResource fsr = new FileSystemResource("classpath:resource/application.xml");
        try {
            defaultListableBeanFactory = new DefaultListableBeanFactory(fsr);
        } catch (Exception e) {
            log.error("defaultListableBeanFactory异常");
        }
    }

    @Test
    public void testDefaultListableBeanFactoryString() {
        try {
            BeanA a = (BeanA) defaultListableBeanFactory.getBean("beana");
            log.info("the  same  food?   " + (a.getFood() == a.getPeople().getFood()));
            log.info(a.getFood().getFoodName());
            Food f=(Food)defaultListableBeanFactory.getBean("food");
            log.info(f.getFoodName()+f.getNumber());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRemoveBeanDefinition() throws Exception {
        defaultListableBeanFactory.removeBeanDefinition("beana");
        BeanA a = defaultListableBeanFactory.getBean("beana", BeanA.class);
        log.info("beanDefinition已经被移除：" + (a == null));
    }

    @Test
    // TODO
    public void testGetBean() {
        People people;
        try {
            people = defaultListableBeanFactory.getBean("people", People.class);
            log.info(people.getFood().say());
        } catch (BeansException e) {
        }
    }
}
