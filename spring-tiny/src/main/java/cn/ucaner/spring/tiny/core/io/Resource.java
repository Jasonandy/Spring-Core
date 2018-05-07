package cn.ucaner.spring.tiny.core.io;

import java.io.File;
import java.io.IOException;

/**
* @Package：cn.ucaner.spring.tiny.core.io   
* @ClassName：Resource   
* @Description：   <p>Resource  </p>
* @Author： -    chen  wentao  
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public interface Resource extends InputStreamSource{
	
	/**
	 * @Description: 文件是否存在
	 * @return boolean
	 * @Autor: Jason - Jasonandy·hotmail.com
	 */
	boolean exists();
	
	/**
	 * @Description: 获取文件对象
	 * @return   - java.io.File;
	 * @throws IOException File
	 * @Autor: Jason - Jasonandy·hotmail.com
	 */
	File getFile() throws IOException;
	
	/**
	 * @Description: 获取文件的描述
	 * @return String
	 * @Autor: Jason - Jasonandy·hotmail.com
	 */
	String getDescription();
	
}
