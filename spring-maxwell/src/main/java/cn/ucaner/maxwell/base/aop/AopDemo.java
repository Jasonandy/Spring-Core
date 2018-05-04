package cn.ucaner.maxwell.base.aop;

/**
* @Package：cn.ucaner.maxwell.base.aop   
* @ClassName：AopDemo   
* @Description：   <p> AopDemo </p>
* @Author： - Jason    
* @CreatTime：2018年5月4日 上午10:41:14   
* @Modify By：   
* @ModifyTime：  2018年5月4日
* @Modify marker：   
* @version    V1.0
 */
public class AopDemo implements AopDemoInter {

    public void send() {
        System.out.println("send from aopdemo");
    }

    public void receive() {
        System.out.println("receive from aopdemo");
    }

    @Override
    public void inter() {
        System.out.println("inter");
    }
}
