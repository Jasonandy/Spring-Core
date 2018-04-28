package cn.ucaner.spring.tiny.bean;

import cn.ucaner.spring.tiny.ioc.annotation.Autowired;
import cn.ucaner.spring.tiny.ioc.annotation.Component;

/**
* @Package：cn.ucaner.spring.tiny.bean   
* @ClassName：DependComponentBean   
* @Description：   <p> DependComponentBean </p>
* @Author： -    
* @Modify By：   
* @ModifyTime：  2018年4月28日
* @Modify marker：   
* @version    V1.0
 */
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
