package cn.ucaner.spring.tiny.core.io;

import java.io.File;
import org.jdom.Document;
import org.jdom.input.SAXBuilder;

/**
* @Package：cn.ucaner.spring.tiny.core.io   
* @ClassName：XmlDocumentResource   
* @Description：   <p> XmlDocumentResource </p>
* @Author： -    
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public class XmlDocumentResource extends DocumentResource{

	public XmlDocumentResource(File file){
		super(file);
	}

	public XmlDocumentResource(String path){
		super(path);
	}
	
	public Document getDocument() throws Exception{
		SAXBuilder builder = new SAXBuilder();
		Document document = builder.build(getFile());// 获得文档对象
		return document;
	}
	
}
