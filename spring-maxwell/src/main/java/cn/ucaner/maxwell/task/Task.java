package cn.ucaner.maxwell.task;

import org.springframework.scheduling.annotation.Async;

/**
* @Package：cn.ucaner.maxwell.task   
* @ClassName：Task   
* @Description：   <p>Test Spring Task. </p>
* @Author： - Jason    
* @CreatTime：2018年5月4日 上午10:45:38   
* @Modify By：   
* @ModifyTime：  2018年5月4日
* @Modify marker：   
* @version    V1.0
 */
public class Task {

    @Async("executor")
    public void print() {
        System.out.println("print执行");
    }

}
