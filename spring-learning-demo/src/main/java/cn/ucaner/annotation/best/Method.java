package cn.ucaner.annotation.best;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* @Package：cn.ucaner.annotation.best   
* @ClassName：Method   
* @Description：   <p> Method</p>
* </br> https://github.com/759796385/spring-leanring-demo 
* </p>
* @Author： - newtonk    
* @CreatTime：2018年4月24日 上午10:56:33   
* @Modify By：   
* @ModifyTime：  2018年4月24日
* @Modify marker：   
* @version    V1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Method {
	
    public String param() default "";
}
