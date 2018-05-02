package cn.ucaner.maxwell.java_config;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.ucaner.maxwell.base.SimpleBean;

/**
 */
public class Bootrap {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SimpleBeanConfig.class);
        SimpleBean simpleBean = context.getBean(SimpleBean.class);
        System.out.println(simpleBean.getStudent().getName());
        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
    }

}
