package cn.ucaner.spring.tiny.bean;

import cn.ucaner.spring.tiny.ioc.annotation.Component;

@Component
public class ComponentBean {
	
	@Override
	public String toString() {
		return "注解注入测试成功";
	}
}
