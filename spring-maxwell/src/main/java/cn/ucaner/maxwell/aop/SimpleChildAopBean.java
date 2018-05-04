package cn.ucaner.maxwell.aop;

/**
* @Package：cn.ucaner.maxwell.aop   
* @ClassName：SimpleChildAopBean   
* @Description：   <p> SimpleChildAopBean </p>
* @Author： - Jason    
* @CreatTime：2018年5月4日 上午10:40:39   
* @Modify By：   
* @ModifyTime：  2018年5月4日
* @Modify marker：   
* @version    V1.0
 */
public class SimpleChildAopBean extends SimpleAopBean {

    @Override
    public void testC() {
        System.out.println("child testC");
    }
}
