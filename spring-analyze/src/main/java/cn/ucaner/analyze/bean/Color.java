package cn.ucaner.analyze.bean;

/**
* @Package：cn.ucaner.analyze.bean   
* @ClassName：Color   
* @Description：   <p> Color </p>
* @Author： - Jason   
* @CreatTime：2018年7月6日 下午11:08:09   
* @Modify By：   
* @ModifyTime：  2018年7月6日
* @Modify marker：   
* @version    V1.0
 */
public class Color {
	
	private Car car;

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Color [car=" + car + "]";
	}
	
	

}
