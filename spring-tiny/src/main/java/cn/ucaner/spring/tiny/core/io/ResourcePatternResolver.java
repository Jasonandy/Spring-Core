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

import java.io.IOException;

/**     
* @Package：cn.ucaner.spring.tiny.core.io   
* @ClassName：ResourcePatternResolver   
* @Description：   <p> ResourcePatternResolver </p>
* @Author： - wubin   
* @CreatTime：2018年5月15日 上午11:54:46   
* @Modify By：   
* @ModifyTime：  2018年5月15日
* @Modify marker：   
* @version    V1.0
*/
public interface ResourcePatternResolver extends ResourceLoader{
	
	/**
	 * classPath 前缀
	 */
	String CLASSPATH_ALL_URL_PREFIX = "classpath*:"; 
	 
	/**
	 * @Description: getResources 
	 * @param locationPattern
	 * @return
	 * @throws IOException Resource[]
	 * @Autor: jason -jasonandy@hotmail.com
	 */
    Resource[] getResources(String locationPattern) throws IOException; 
 

}
