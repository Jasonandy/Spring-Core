package cn.ucaner.aop.service.impl;


import cn.ucaner.aop.service.Axe;

/**
* @Package：cn.ucaner.aop.service.impl   
* @ClassName：SteelAxe   
* @Description：   <p> SteelAxe </p>
* @Author： -    newtonk
* @Modify By：   
* @Modify marker：   
* @version    V1.0
 */
public class SteelAxe implements Axe {

	@Override
	public String chop() {
		return "钢斧好多了";
	}

	public String getName() {
		return "不错~";
	}

}
