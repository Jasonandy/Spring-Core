package cn.ucaner.maxwell.java_config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.context.annotation.Scope;
import org.springframework.core.type.AnnotationMetadata;

import cn.ucaner.maxwell.base.Student;

/**
 * {@link base.Student}配置
 *
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
