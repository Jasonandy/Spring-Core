package cn.ucaner.maxwell.local;

import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

/**
* @Package：cn.ucaner.maxwell.local   
* @ClassName：Local   
* @Description：   <p> java本地化相关 </p>
* @Author： - Jason    
* @CreatTime：2018年5月4日 上午10:45:10   
* @Modify By：   
* @ModifyTime：  2018年5月4日
* @Modify marker：   
* @version    V1.0
 */
public class Local {

	@Test
	public void resourceBoundle() {
		//此文件必须放在classpath下面
		ResourceBundle bundle = ResourceBundle.getBundle("resource/resource", Locale.US);
		System.out.println("US: " + bundle.getString("greeting.common"));
		bundle = ResourceBundle.getBundle("resource/resource", Locale.CHINA);
		System.out.println("CN: " + bundle.getString("greeting.common"));
	}
	
}
//Outputs 
//US: How are you! 
//CN: 您好！ 
