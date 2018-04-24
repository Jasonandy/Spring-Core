package cn.ucaner.annotation.best;

/**
 * 
* @Package：cn.ucaner.annotation.best   
* @ClassName：Exam   
* @Description：   <p> Exam
* </br> https://github.com/759796385/spring-leanring-demo 
* </p>
* @Author： - newtonk    
* @CreatTime：2018年4月24日 上午10:56:33   
* @Modify By：   
* @ModifyTime：  2018年4月24日
* @Modify marker：   
* @version    V1.0
 */
public interface Exam {

    public String answer(@Param String name);
}
