package cn.ucaner.analyze.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @Package：cn.ucaner.analyze.tx   
* @ClassName：UserService   
* @Description：   <p> UserService </p>
* @Author： - Jason   
* @CreatTime：2018年7月6日 下午11:21:27   
* @Modify By：   
* @ModifyTime：  2018年7月6日
* @Modify marker：   
* @version    V1.0
 */
@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Transactional
	public void insertUser(){
		userDao.insert();
		//otherDao.other();xxx
		System.out.println("插入完成...");
		int i = 10/0;
	}

}
