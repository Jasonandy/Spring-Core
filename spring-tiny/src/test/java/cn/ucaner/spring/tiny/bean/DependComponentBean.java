package cn.ucaner.spring.tiny.bean;

import cn.ucaner.spring.tiny.ioc.annotation.Autowired;
import cn.ucaner.spring.tiny.ioc.annotation.Component;

@Component
public class DependComponentBean {
	
    @Autowired(value="componentbean")
	private ComponentBean componentbean;

	@Override
	public String toString() {
		return "DependComponentBean："+componentbean.toString();
	}

    public ComponentBean getComponentbean() {
        return componentbean;
    }

    public void setComponentbean(ComponentBean componentbean) {
        this.componentbean = componentbean;
    }
	
}
