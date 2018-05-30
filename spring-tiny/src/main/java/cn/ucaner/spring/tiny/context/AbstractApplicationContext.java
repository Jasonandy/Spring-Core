/**
 * <html>
 * <body>
 *  <P> Copyright  JasonInternational </p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason. The Source On WebSite .  https://github.com/Jasonandy/Spring-Core </p>
 *  </body>
 * </html>
 */
package cn.ucaner.spring.tiny.context;

import cn.ucaner.spring.tiny.beans.factory.AutowireCapableBeanFactory;
import cn.ucaner.spring.tiny.core.io.DefaultResourceLoader;

/**
* @Package：cn.ucaner.spring.tiny.context   
* @ClassName：AbstractApplicationContext   
* @Description：   <p> AbstractApplicationContext
* 
* - 抽象应用上下文容器
* 
* </p>
* @Author： -    
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ApplicationContext,AutowireCapableBeanFactory{

}
