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

import java.io.File;

/**
* @Package：cn.ucaner.spring.tiny.core.io   
* @ClassName：DocumentResource   
* @Description：   <p> DocumentResource 
* beandefinition
* </p>
* @Author： -    
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public class DocumentResource extends FileSystemResource{
	
	/**
	* DocumentResource.  资源中加载
	* @param file
	 */
	public DocumentResource(File file){
		super(file);
	}
	
	/**
	* DocumentResource.   路径加载
	* @param path
	 */
	public DocumentResource(String path){
		super(path);
	}
	
	/**
	 * 资源的描述
	 */
	@Override
	public String getDescription() {
		return "[Tiny-Spring]This is a Resource : "+super.getDescription();
	}
	
}
