package cn.ucaner.maxwell.java_config;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.ucaner.maxwell.base.SimpleBean;

/**
* @Package：cn.ucaner.maxwell.java_config   
* @ClassName：Bootrap   
* @Description：   <p> Bootrap </p>
* @Author： - Jason    
* @CreatTime：2018年5月4日 上午10:44:33   
* @Modify By：   
* @ModifyTime：  2018年5月4日
* @Modify marker：   
* @version    V1.0
 */
public class Bootrap {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SimpleBeanConfig.class);
        SimpleBean simpleBean = context.getBean(SimpleBean.class);
        System.out.println(simpleBean.getStudent().getName());
        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
        context.close();
    }

}
//Outputs 
//importaware
//Jason
