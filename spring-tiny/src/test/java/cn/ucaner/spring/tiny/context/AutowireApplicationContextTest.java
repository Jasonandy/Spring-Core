package cn.ucaner.spring.tiny.context;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.ucaner.spring.tiny.bean.AutowiredBean;
import cn.ucaner.spring.tiny.bean.ComponentBean;
import cn.ucaner.spring.tiny.bean.DependComponentBean;
import cn.ucaner.spring.tiny.beans.factory.DefaultListableBeanFactory;
import cn.ucaner.spring.tiny.core.io.FileSystemResource;
import cn.ucaner.spring.tiny.tools.Assert;

/**
* @Package：cn.ucaner.spring.tiny.context   
* @ClassName：AutowireApplicationContextTest   
* @Description：   <p> AutowireApplicationContextTest</p>
* @Author： -    
* @Modify By：   
* @ModifyTime：  2018年4月28日
* @Modify marker：   
* @version    V1.0
 */
public class AutowireApplicationContextTest {

    private static Logger log = LoggerFactory.getLogger(AutowireApplicationContextTest.class);
    DefaultListableBeanFactory defaultListableBeanFactory;
    static {
        PropertyConfigurator.configure("log4j.properties");
    }

    @Test
    public void testAutowireApplicationContext() {
        // 注入一个resource
        FileSystemResource fsr = new FileSystemResource("resource/application.xml");
        try {
            AutowireApplicationContext aac = new AutowireApplicationContext(fsr);
            AutowiredBean autowiredbean=aac.getBean("autowiredbean", AutowiredBean.class);
            ComponentBean cb = aac.getBean("componentbean", ComponentBean.class);
            DependComponentBean dcb = aac.getBean("dependcomponentbean", DependComponentBean.class);
            log.info(cb.toString());
            log.info(dcb.toString());
            log.info(Assert.isNull(autowiredbean.getBeana().getFood().say()));
            log.info(autowiredbean.getBeana().getPeople().getFood().say());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
