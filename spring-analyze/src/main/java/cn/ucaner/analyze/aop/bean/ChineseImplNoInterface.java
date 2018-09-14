package cn.ucaner.analyze.aop.bean;

import org.springframework.stereotype.Component;

@Component
public class ChineseImplNoInterface {

	/***
	 * @Description:init 
	 * @Autor: Jason
	 */
    @SuppressWarnings("unused")
	private void init(){
        System.out.println(ChineseImplNoInterface.class + " init ");
    }
}
