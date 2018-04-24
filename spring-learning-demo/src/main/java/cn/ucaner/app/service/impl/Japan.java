package cn.ucaner.app.service.impl;


import cn.ucaner.app.service.Person;

/**
* @Package：cn.ucaner.app.service.impl   
* @ClassName：Japan   
* @Description：   <p> TODO</p>
* @Author： -    newtonk
* @Modify By：   
* @Modify marker：   
* @version    V1.0
 */
public abstract class Japan implements Person {
	private SteelAxe steelaxe;

	// 定义抽象方法，该方法用于获取被依赖的bean
	public abstract SteelAxe getSteelAxe();

	public void hunt() {
		System.out.println("我用" + getSteelAxe() + "砍树");
		System.out.println(getSteelAxe().chop());
	}
}
