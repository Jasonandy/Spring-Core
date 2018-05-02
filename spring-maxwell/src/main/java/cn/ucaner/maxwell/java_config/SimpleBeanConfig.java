package cn.ucaner.maxwell.java_config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import cn.ucaner.maxwell.base.SimpleBean;

/**
 * {@link base.SimpleBean}配置
 *
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
