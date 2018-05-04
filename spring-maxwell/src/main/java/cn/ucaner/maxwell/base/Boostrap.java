package cn.ucaner.maxwell.base;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.ucaner.maxwell.base.transaction.TransactionBean;

/**
* @Package：cn.ucaner.maxwell.base   
* @ClassName：Boostrap   
* @Description：   <p> Boostrap </p>
* @Author： - Jason    
* @CreatTime：2018年5月4日 上午10:43:11   
* @Modify By：   
* @ModifyTime：  2018年5月4日
* @Modify marker：   
* @version    V1.0
 */
public class Boostrap {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        TransactionBean bean = context.getBean(TransactionBean.class);
        System.out.println(bean.toString());//cn.ucaner.maxwell.base.transaction.TransactionBean@28eaa59a
        bean.process();
        context.close();
    }
	
}
