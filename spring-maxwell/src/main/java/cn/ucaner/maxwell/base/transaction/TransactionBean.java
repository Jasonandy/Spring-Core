package cn.ucaner.maxwell.base.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
* @Package：cn.ucaner.maxwell.base.transaction   
* @ClassName：TransactionBean   
* @Description：   <p> 测试事务. </p>
* @Author： - Jason    
* @CreatTime：2018年5月4日 上午10:42:50   
* @Modify By：   
* @ModifyTime：  2018年5月4日
* @Modify marker：   
* @version    V1.0
 */
@Component
public class TransactionBean {

	@Autowired
    private NestedBean nestedBean;
	 
    public NestedBean getNestedBean() {
        return nestedBean;
    }

    public void setNestedBean(NestedBean nestedBean) {
        this.nestedBean = nestedBean;
    }


    @Transactional(propagation = Propagation.REQUIRED)
    public void process() {
        System.out.println("事务执行");
        nestedBean.nest();//测试嵌套事物 Exception in thread "main" java.lang.NullPointerException
    }

}
