package cn.ucaner.analyze.aop.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import cn.ucaner.analyze.aop.factory.impl.AudiCarImpl;

@Component
public class CarFactory implements FactoryBean<Car> {

    private Car car;

    
    /**
     * 单例模式 获取Car Impl Object
     */
    @Override
    public Car getObject() throws Exception {
        if(car==null){
            this.car = new AudiCarImpl();
        }
        return car;
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
