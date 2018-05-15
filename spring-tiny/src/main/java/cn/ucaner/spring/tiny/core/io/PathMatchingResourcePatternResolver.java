/**
 * <html>
 * <body>
 *  <P> Copyright JasonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2018年5月15日 上午11:57:48</p>
 *  <p> Created by wubin</p>
 *  </body>
 * </html>
 */
package cn.ucaner.spring.tiny.core.io;

import java.io.IOException;

/**     
* @Package：cn.ucaner.spring.tiny.core.io   
* @ClassName：PathMatchingResourcePatternResolver   
* @Description：   <p> PathMatchingResourcePatternResolver </p>
* @Author： - Jason   
* @CreatTime：2018年5月15日 上午11:57:48   
* @Modify By：   
* @ModifyTime：  2018年5月15日
* @Modify marker：   
* @version    V1.0
*/
public class PathMatchingResourcePatternResolver implements ResourcePatternResolver{

	@Override
	public Resource getResource(String location) {
		return null;
	}

	@Override
	public ClassLoader getClassLoader() {
		return null;
	}

	@Override
	public Resource[] getResources(String locationPattern) throws IOException {
		return null;
	}

}
