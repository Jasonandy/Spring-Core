package cn.ucaner.app.service.impl;


import cn.ucaner.app.service.Axe;
import cn.ucaner.app.service.Person;

/**
* @Package：cn.ucaner.app.service.impl   
* @ClassName：Chinese   
* @Description：   <p> TODO</p>
* @Author： -    newtonk
* @Modify By：   
* @Modify marker：   
* @version    V1.0
 */
public class Chinese implements Person {
	private Axe axe;

	public Chinese() {
		System.out.println("=====无参构造器====");
	}

	public void setAxe(Axe axe) {
		this.axe = axe;
	}

	public void setTest(String name) {
		System.out.println("调用set方法进行中注入~~" + name);
	}

	@Override
	public void useAxe() {
		System.out.println(axe.chop());
	}

}
