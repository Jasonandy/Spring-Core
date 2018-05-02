package cn.ucaner.spring.tiny.exception;

/**
* @Package：cn.ucaner.spring.tiny.exception   
* @ClassName：NoSuchBeanDefinitionException   
* @Description：   <p> NoSuchBeanDefinitionException 
* 
* - 没有这个bean的定义 - 
* </p>
* @Author： -    
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public class NoSuchBeanDefinitionException extends BeansException {

    private static final long serialVersionUID = 1L;

    public NoSuchBeanDefinitionException(String string){
		//TODO日志输出
	}

}
