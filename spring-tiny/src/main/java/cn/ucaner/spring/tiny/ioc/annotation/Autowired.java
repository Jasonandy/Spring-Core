package cn.ucaner.spring.tiny.ioc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* @Package：cn.ucaner.spring.tiny.ioc.annotation   
* @ClassName：Autowired   
* @Description：   <p> Autowired
* 
* - 注解自动注入
*  
*  </p>
* @Author： -    
* @CreatTime：2018年4月27日 上午10:51:08   
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Autowired {
	
	public String value() default "";
}
