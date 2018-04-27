package cn.ucaner.spring.tiny.context;

import cn.ucaner.spring.tiny.beans.factory.AutowireCapableBeanFactory;
import cn.ucaner.spring.tiny.core.io.DefaultResourceLoader;

/**
* @Package：cn.ucaner.spring.tiny.context   
* @ClassName：AbstractApplicationContext   
* @Description：   <p> AbstractApplicationContext</p>
* @Author： -    
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ApplicationContext,AutowireCapableBeanFactory{

}
