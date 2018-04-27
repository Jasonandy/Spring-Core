package cn.ucaner.spring.tiny.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
* @Package：cn.ucaner.spring.tiny.core.io   
* @ClassName：FileSystemResource   
* @Description：   <p> 
* 主要实现了Resource接口中的getFile() 以及重写了AbstractResource类中的getDescription()方法
* ps:为什么不在AbstractResource类中就将其实现呢？
* 	1.接口Resource主要定义的是一份资源的基本规范：三个方法(1.获取资源的File对象，描述，以及资源是否存在)
* 	对于AbstractResource类只实现了Resource接口的exists()方法，当以后我们从不同的地方获取资源的
* 	时，只需要继承AbstractResource实现不同的Resource就可以，实现的过程分的越细致，代码可拓展性越高
* 	例如：ClassPathResource，BeanDefinition...
* </p>
* @Author： - chen wentao   
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public class FileSystemResource extends AbstractResource {

	private final File file;

	private final String path;
	
	public FileSystemResource(File file){
		this.file = file;
		this.path = file.getAbsolutePath();
	}
	
	public FileSystemResource(String path){
		this.path = path;
		this.file = new File(path);
	}
	/*
	 * 实现接口Resource中的getDescription()方法，(资源的描述)
	 */
	@Override
	public String getDescription(){
		return "资源的描述："+file.getName()+
				"  "+"地址为："+path;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		return new FileInputStream(this.file);
	}

	@Override
	public File getFile() throws IOException {
		return this.file;
	}

}
