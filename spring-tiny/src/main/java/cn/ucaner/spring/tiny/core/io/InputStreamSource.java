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
import java.io.InputStream;

/**
* @Package：cn.ucaner.spring.tiny.core.io   
* @ClassName：InputStreamSource   
* @Description：   <p> InputStreamSource </p>
* @Author： -    
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public interface InputStreamSource {
	
	/**
	 * @Description: 获取输入流
	 * @return
	 * @throws IOException InputStream
	 * @Autor: Jason - jasonandy@hotmail.com
	 */
	InputStream getInputStream() throws IOException;

}
