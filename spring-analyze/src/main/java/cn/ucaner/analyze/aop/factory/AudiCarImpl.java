package cn.ucaner.analyze.aop.factory;

public class AudiCarImpl implements Car {
    @Override
    public void driveCar() {
        System.out.println("audi car drive");
    }

    @Override
    public void saleCar() {
        System.out.println("audi car sale");

    }


}
