package cn.ucaner.spring.tiny.exception;

public class XmlConfigurationErrorException extends ConfigurationErrorException {

	private static final long serialVersionUID = 1L;
	
	public XmlConfigurationErrorException(String str){
		super(str);
	}

}
