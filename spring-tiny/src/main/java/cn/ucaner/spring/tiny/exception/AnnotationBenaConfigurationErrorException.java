package cn.ucaner.spring.tiny.exception;

/**
* @Package：cn.ucaner.spring.tiny.exception   
* @ClassName：AnnotationBenaConfigurationErrorException   
* @Description：   <p> 当解析注解错误时报出此异常 </p>
* @Author： - cwt   
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public class AnnotationBenaConfigurationErrorException extends ConfigurationErrorException{
    
    private static final long serialVersionUID = 1L;

    public AnnotationBenaConfigurationErrorException(String message) {
        super(message);
    }
}
