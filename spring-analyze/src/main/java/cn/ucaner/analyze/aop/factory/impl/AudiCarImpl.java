package cn.ucaner.analyze.aop.factory.impl;

import cn.ucaner.analyze.aop.factory.Car;

/**
* @Package：cn.ucaner.analyze.aop.factory.impl   
* @ClassName：AudiCarImpl   
* @Description：   <p> Car实例</p>
* @Author： -    
* @CreatTime：2018年5月15日 下午3:19:35   
* @Modify By：   
* @ModifyTime：  2018年5月15日
* @Modify marker：   
* @version    V1.0
 */
public class AudiCarImpl implements Car {
	
    @Override
    public void driveCar() {
        System.out.println("Audi car drive .");
    }

    @Override
    public void saleCar() {
        System.out.println("Audi car sale .");

    }

	@Override
	public String echo(String echo) {
		return echo == null? "I'm Echo Method" : echo + " Hi cglib Proxy.";
	}

}
