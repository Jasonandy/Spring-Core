package cn.ucaner.analyze.aop.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class CarFactory implements FactoryBean<Car> {

    private Car car;

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
