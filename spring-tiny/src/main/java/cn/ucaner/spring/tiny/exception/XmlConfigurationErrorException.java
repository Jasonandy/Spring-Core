package cn.ucaner.spring.tiny.exception;


/**
* @Package：cn.ucaner.spring.tiny.exception   
* @ClassName：XmlConfigurationErrorException   
* @Description：   <p> XmlConfigurationErrorException </p>
* @Author： -    
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public class XmlConfigurationErrorException extends ConfigurationErrorException {

	private static final long serialVersionUID = 1L;
	
	public XmlConfigurationErrorException(String str){
		super(str);
	}

}
