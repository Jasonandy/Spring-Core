package cn.ucaner.spring.tiny.bean;

import cn.ucaner.spring.tiny.ioc.annotation.Component;

/**
* @Package：cn.ucaner.spring.tiny.bean   
* @ClassName：ComponentBean   
* @Description：   <p> ComponentBean </p>
* @Author： -    
* @Modify By：   
* @ModifyTime：  2018年4月28日
* @Modify marker：   
* @version    V1.0
 */
@Component
public class ComponentBean {
	
	@Override
	public String toString() {
		return "注解注入测试成功";
	}
}
