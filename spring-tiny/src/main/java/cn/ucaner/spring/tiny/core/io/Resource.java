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
	
	boolean exists();
	
	File getFile() throws IOException;
	
	//return a  description for the  resource
	String getDescription();
	
}
