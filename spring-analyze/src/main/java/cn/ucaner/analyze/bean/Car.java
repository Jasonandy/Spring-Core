package cn.ucaner.analyze.bean;

import org.springframework.stereotype.Component;

/**
* @Package：cn.ucaner.analyze.bean   
* @ClassName：Car   
* @Description：   <p> Car </p>
* @Author： - Jason   
* @CreatTime：2018年7月6日 下午11:07:27   
* @Modify By：   
* @ModifyTime：  2018年7月6日
* @Modify marker：   
* @version    V1.0
 */
@Component
public class Car {
	
	public Car(){
		System.out.println("car constructor...");
	}
	
	public void init(){
		System.out.println("car ... init...");
	}
	
	public void detory(){
		System.out.println("car ... detory...");
	}

}
