package cn.ucaner.analyze.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import cn.ucaner.analyze.bean.Person;

/**
* @Package：cn.ucaner.analyze.config   
* @ClassName：MainConfigOfPropertyValues   
* @Description：   <p> 使用@PropertySource读取外部配置文件中的k/v保存到运行的环境变量中;加载完外部的配置文件以后使用${}取出配置文件的值 </p>
* @Author： - Jason   
* @CreatTime：2018年7月6日 下午11:27:43   
* @Modify By：   
* @ModifyTime：  2018年7月6日
* @Modify marker：   
* @version    V1.0
 */
@PropertySource(value={"classpath:/person.properties"})
@Configuration
public class MainConfigOfPropertyValues {
	
	@Bean
	public Person person(){
		return new Person();
	}

}
