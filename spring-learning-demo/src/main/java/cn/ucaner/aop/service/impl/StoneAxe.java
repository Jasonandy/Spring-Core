package cn.ucaner.aop.service.impl;

import cn.ucaner.aop.service.Axe;

/**
* @Package：cn.ucaner.aop.service.impl   
* @ClassName：StoneAxe   
* @Description：   <p> StoneAxe </p>
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
