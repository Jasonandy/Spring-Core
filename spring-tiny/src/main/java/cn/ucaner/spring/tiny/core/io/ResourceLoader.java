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
	
	Resource getResource(String location);
}
