package cn.ucaner.analyze.aop.factory;

import org.springframework.stereotype.Component;

/**
* @Package：cn.ucaner.analyze.aop.factory   
* @ClassName：Car   
* @Description：   <p> 定义接口 - Car </p>
 */
public interface Car {

	/**
	 * 开车
	 */
    void driveCar();

    /**
     * 售车
     */
    void saleCar();
    
    /**
     * @Description: For cglib proxy 
     * @param echo
     */
    String echo(String echo);
}
