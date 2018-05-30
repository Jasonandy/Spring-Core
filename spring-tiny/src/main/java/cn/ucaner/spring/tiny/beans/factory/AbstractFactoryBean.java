/**
 * <html>
 * <body>
 *  <P> Copyright  JasonInternational </p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason. The Source On WebSite .  https://github.com/Jasonandy/Spring-Core </p>
 *  </body>
 * </html>
 */
package cn.ucaner.spring.tiny.beans.factory;

/**
* @Package：cn.ucaner.spring.tiny.beans.factory   
* @ClassName：AbstractFactoryBean   
* @Description：   <p> AbstractFactoryBean </p>
* @Author： -    
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public abstract class AbstractFactoryBean<T> implements FactoryBean<T> {
   
	private boolean singleton = true;

	@Override
	public boolean isSingleton() {
		return singleton;
	}

}
