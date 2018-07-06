package cn.ucaner.analyze.dao;

import org.springframework.stereotype.Repository;

/**
* @Package：cn.ucaner.analyze.dao   
* @ClassName：BookDao   
* @Description：   <p> 名字默认是类名首字母小写 </p>
* @Author： - Jason   
* @CreatTime：2018年7月6日 下午11:25:17   
* @Modify By：   
* @ModifyTime：  2018年7月6日
* @Modify marker：   
* @version    V1.0
 */
@Repository
public class BookDao {
	
	private String lable = "1";

	public String getLable() {
		return lable;
	}

	public void setLable(String lable) {
		this.lable = lable;
	}

	@Override
	public String toString() {
		return "BookDao [lable=" + lable + "]";
	}
}
