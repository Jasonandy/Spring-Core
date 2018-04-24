package cn.ucaner.app.service.impl;


import cn.ucaner.app.service.Axe;

/**
* @Package：cn.ucaner.app.service.impl   
* @ClassName：StoneAxe   
* @Description：   <p> TODO</p>
* @Author： -    newtonk
* @Modify By：   
* @Modify marker：   
* @version    V1.0
 */
public class StoneAxe implements Axe {

	@Override
	public String chop() {
		return "石头砍柴好慢";
	}

}
