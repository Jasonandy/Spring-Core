package cn.ucaner.spring.tiny.ioc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* @Package：cn.ucaner.spring.tiny.ioc.annotation   
* @ClassName：Component   
* @Description：   <p> Component 标注一个普通的Spring Bean类。
* 在这种下，Bean实例的名称默认是Bean类的首字母小写
* 还可以在使用@Component标注时指定Bean实例的名称. 
* eg : @Component("jason")</p>
* @Author： -   
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
	
	 String name() default "";
}
