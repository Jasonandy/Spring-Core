package cn.ucaner.spring.tiny.core.io;

/**
* @Package：cn.ucaner.spring.tiny.core.io   
* @ClassName：DefaultResourceLoader   
* @Description：   <p> DefaultResourceLoader 
*  默认获取资源的方式：Spring官方返回的是一个ClassPathContextResource，在这里，我统一使用
*  从文件系统中获取Resource的方式
*  </p>
* @Author： -    
* @CreatTime：2018年4月27日 下午6:03:45   
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public class DefaultResourceLoader implements ResourceLoader{

	@Override
	public Resource getResource(String path){
		return new FileSystemResource(path);
	}

	@Override
	public ClassLoader getClassLoader() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
