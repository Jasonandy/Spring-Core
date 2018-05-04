package cn.ucaner.maxwell.java_config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import cn.ucaner.maxwell.base.SimpleBean;

/**
* @Package：cn.ucaner.maxwell.java_config   
* @ClassName：SimpleBeanConfig   
* @Description：   <p> {@link base.SimpleBean}配置 </p>
* @Author： - Jason    
* @CreatTime：2018年5月4日 上午10:44:43   
* @Modify By：   
* @ModifyTime：  2018年5月4日
* @Modify marker：   
* @version    V1.0
 */
@Configuration
@Import(StudentConfig.class)
public class SimpleBeanConfig {

    @Autowired
    private StudentConfig studentConfig;

    @Bean
    public SimpleBean simpleBean() {
        SimpleBean simpleBean = new SimpleBean(studentConfig.student());
        return simpleBean;
    }

}
