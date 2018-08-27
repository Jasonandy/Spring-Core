package cn.ucaner.analyze.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import cn.ucaner.analyze.bean.Person;

//配置类==配置文件
@Configuration  //告诉Spring这是一个配置类

@ComponentScans(
		value = {
				@ComponentScan(value="cn.ucaner.analyze",includeFilters = { //排除规则 
						/*@Filter(type=FilterType.ANNOTATION,classes={Controller.class}),*/ //按照注解除 - 排除controller注解的bean
						//@Filter(type=FilterType.ASSIGNABLE_TYPE,classes={cn.ucaner.analyze.data.mybatis.entity.UserEntity.class}),
						@Filter(type=FilterType.CUSTOM,classes={MyTypeFilter.class})  //自定的信息 - 自己自定义的规则
				},useDefaultFilters = false)//禁用掉默认的	
		}
		)
//@ComponentScan  value:指定要扫描的包
//excludeFilters = Filter[] ：指定扫描的时候按照什么规则排除那些组件 - 排除
//includeFilters = Filter[] ：指定扫描的时候只需要包含哪些组件 -包含 
/**
* @Package：cn.ucaner.analyze.config   
* @ClassName：MainConfig   
* @Description：   <p> MainConfig </p>
* @Author： - Jason   
* @CreatTime：2018年8月25日 下午12:54:34   
* @Modify By：   
* @ModifyTime：  2018年8月25日
* @Modify marker：   
* @version    V1.0
 */

//FilterType.ANNOTATION：按照注解
//FilterType.ASSIGNABLE_TYPE：按照给定的类型，按照给定的类型
//FilterType.ASPECTJ：使用ASPECTJ表达式  - 不常用
//FilterType.REGEX：使用正则指定 - 使用的正则表达式
//FilterType.CUSTOM：使用自定义规则  - 自定的规则   - typeFilter的实现类
public class MainConfig {
	
	//给容器中注册一个Bean;类型为返回值的类型,id默认是用方法名作为id,默认是方法名字.
	@Bean("person")
	public Person person01(){
		return new Person("lisi", 20);
	}

}
