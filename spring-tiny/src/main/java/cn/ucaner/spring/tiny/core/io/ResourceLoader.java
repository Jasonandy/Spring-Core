/**
 * <html>
 * <body>
 *  <P> Copyright  JasonInternational </p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason. The Source On WebSite .  https://github.com/Jasonandy/Spring-Core </p>
 *  </body>
 * </html>
 */
package cn.ucaner.spring.tiny.core.io;

/**
* @Package：cn.ucaner.spring.tiny.core.io   
* @ClassName：ResourceLoader   
* @Description：   <p> ResourceLoader </p>
* @Author： -    
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public interface ResourceLoader{
	
	/**
	 * "classpath*:"  ResourceUtils.CLASSPATH_URL_PREFIX
	 */
    String CLASSPATH_URL_PREFIX ="classpath*:" ; 
	
	Resource getResource(String location);
	
	/**
	 * @Description: getClassLoader
	 * @return ClassLoader
	 * @Autor: jasonandy - jasonandy@hotmial.com
	 */
	ClassLoader getClassLoader(); 
}
