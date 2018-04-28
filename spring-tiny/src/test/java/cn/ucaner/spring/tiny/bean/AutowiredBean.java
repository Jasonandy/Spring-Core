package cn.ucaner.spring.tiny.bean;

import cn.ucaner.spring.tiny.ioc.annotation.Autowired;
import cn.ucaner.spring.tiny.ioc.annotation.Component;

/**
* @Package：cn.ucaner.spring.tiny.bean   
* @ClassName：AutowiredBean   
* @Description：   <p> AutowiredBean </p>
* @Author： -    
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
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
