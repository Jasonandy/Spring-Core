package cn.ucaner.spring.tiny.exception;

public class ConfigurationErrorException extends Exception{
	
    private static final long serialVersionUID = 1L;
    
	public ConfigurationErrorException(String message) {
        super(message);
    }

}
