package cn.ucaner.maxwell.base.transaction;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
* @Package：cn.ucaner.maxwell.base.transaction   
* @ClassName：NestedBean   
* @Description：   <p> 测试嵌套事务. </p>
* @Author： - Jason    
* @CreatTime：2018年5月4日 上午10:42:36   
* @Modify By：   
* @ModifyTime：  2018年5月4日
* @Modify marker：   
* @version    V1.0
 */
@Component
public class NestedBean {

    @Transactional(propagation = Propagation.NESTED)
    public void nest() {
        System.out.println("嵌套事务");
    }

}
