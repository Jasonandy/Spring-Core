package cn.ucaner.aop.factory;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Field;

/**
* @Package：cn.ucaner.aop.factory   
* @ClassName：PersonFactory   
* @Description：   <p> PersonFactory </p>
* @Author： -    newtonk
* @Modify By：   
* @Modify marker：   
* @version    V1.0
 */
public class PersonFactory implements FactoryBean<Object> {
	
    private String targetClass;
    private String targetFiled;

    public void setTargetClass(String targetClass) {
        this.targetClass = targetClass;
    }

    public void setTargetFiled(String targetFiled) {
        this.targetFiled = targetFiled;
    }

    // 返回工厂bean所生产的产品
    @Override
    public Object getObject() throws Exception {
        Class clazz = Class.forName(targetClass);
        Field field = clazz.getField(targetFiled);
        return field.get(null);
    }

    // 获取工厂bean所产生的产品类型
    @Override
    public Class<?> getObjectType() {
        return Object.class;
    }

    // 返回生成的bean是否是单例
    @Override
    public boolean isSingleton() {
        return false;
    }

}
