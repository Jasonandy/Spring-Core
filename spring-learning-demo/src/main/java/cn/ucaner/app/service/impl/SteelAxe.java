package cn.ucaner.app.service.impl;


import cn.ucaner.app.service.Axe;

/**
* @Package：cn.ucaner.app.service.impl   
* @ClassName：SteelAxe   
* @Description：   <p> TODO</p>
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
