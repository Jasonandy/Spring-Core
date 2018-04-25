package cn.ucaner.spring.tiny.bean;

import cn.ucaner.spring.tiny.ioc.annotation.Autowired;
import cn.ucaner.spring.tiny.ioc.annotation.Component;

@Component
public class AutowiredBean {
    	
    @Autowired(value="beana")
	private BeanA beana;
	
	public String say(){
	  return beana.toString();
	}

    public BeanA getBeana() {
        return beana;
    }

    public void setBeana(BeanA beana) {
        this.beana = beana;
    }

}
