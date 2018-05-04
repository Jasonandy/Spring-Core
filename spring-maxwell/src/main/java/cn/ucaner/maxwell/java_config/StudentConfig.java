package cn.ucaner.maxwell.java_config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.context.annotation.Scope;
import org.springframework.core.type.AnnotationMetadata;

import cn.ucaner.maxwell.base.Student;

/**
* @Package：cn.ucaner.maxwell.java_config   
* @ClassName：StudentConfig   
* @Description：   <p> {@link base.Student}配置 </p>
* @Author： - Jason    
* @CreatTime：2018年5月4日 上午10:44:53   
* @Modify By：   
* @ModifyTime：  2018年5月4日
* @Modify marker：   
* @version    V1.0
 */
@Configuration
public class StudentConfig implements ImportAware {

    @Bean
    @Scope("prototype")
    public Student student() {
        Student student = new Student();
        student.setAge(22);
        student.setName("Jason");
        return student;
    }

    @Override
    public void setImportMetadata(AnnotationMetadata importMetadata) {
        System.out.println("importaware");
    }
}
