package cn.ucaner.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* @Package：cn.ucaner.annotation   
* @ClassName：Try   
* @Description：   <p>注解 - Try </p>
* </br> https://github.com/759796385/spring-leanring-demo 
* </p>
* @Author： - newtonk    
* @CreatTime：2018年4月24日 上午10:56:33   
* @Modify By：   
* @ModifyTime：  2018年4月24日
* @Modify marker：   
* @version    V1.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Try {
	
    public enum Color{RED,BLUE,YELLOW,NONE}

    public String color() default "NONE";
}
