package cn.ucaner.maxwell.base;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.ucaner.maxwell.base.transaction.TransactionBean;

public class Boostrap {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        TransactionBean bean = context.getBean(TransactionBean.class);
        System.out.println(bean.toString());//cn.ucaner.maxwell.base.transaction.TransactionBean@28eaa59a
        bean.process();
        context.close();
    }
	
}
