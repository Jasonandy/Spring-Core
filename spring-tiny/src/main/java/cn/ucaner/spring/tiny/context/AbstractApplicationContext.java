package cn.ucaner.spring.tiny.context;

import cn.ucaner.spring.tiny.beans.factory.AutowireCapableBeanFactory;
import cn.ucaner.spring.tiny.core.io.DefaultResourceLoader;

public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ApplicationContext,AutowireCapableBeanFactory{

}
