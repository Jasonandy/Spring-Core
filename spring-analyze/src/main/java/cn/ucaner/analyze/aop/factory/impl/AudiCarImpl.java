package cn.ucaner.analyze.aop.factory.impl;

import cn.ucaner.analyze.aop.factory.Car;

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
