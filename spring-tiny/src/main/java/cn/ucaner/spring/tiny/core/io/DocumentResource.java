package cn.ucaner.spring.tiny.core.io;

import java.io.File;

/**
* @Package：cn.ucaner.spring.tiny.core.io   
* @ClassName：DocumentResource   
* @Description：   <p> DocumentResource 
* 它也是屬於穩健系統的資源的,當我們需要從其他的穩健資源中獲取
* beandefinition時，直接繼承就行了
* </p>
* @Author： -    
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public class DocumentResource extends FileSystemResource{
	
	public DocumentResource(File file)
	{
		super(file);
		
	}
	public DocumentResource(String path)
	{
		super(path);
		
	}
	/* (non-Javadoc)
	 * @see com.lonton.core.io.FileSystemResource#getDescription()
	 */
	@Override
	public String getDescription() {
		//重寫下getDescription()方法
		return "這是一個穩健Resource："+super.getDescription();
	}
	
	
}
