package cn.ucaner.spring.tiny.exception;

/**
* @Package：cn.ucaner.spring.tiny.exception   
* @ClassName：ConfigurationErrorException   
* @Description：   <p> ConfigurationErrorException</p>
* @Author： -    
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public class ConfigurationErrorException extends Exception{
	
    private static final long serialVersionUID = 1L;
    
	public ConfigurationErrorException(String message) {
        super(message);
    }

}
