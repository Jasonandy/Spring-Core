package cn.ucaner.annotation.best;

/**
* @Package：cn.ucaner.annotation.best   
* @ClassName：Max   
* @Description：   <p> Exam </p>
* </br> https://github.com/759796385/spring-leanring-demo 
* </p>
* @Author： - newtonk    
* @CreatTime：2018年4月24日 上午10:56:33   
* @Modify By：   
* @ModifyTime：  2018年4月24日
* @Modify marker：   
* @version    V1.0
 */
public class Max implements Exam{

    /**
     *  只有传入a开头才执行
     *  参数变为 param+name
     */
    @Method(param= "方法附加值. 真正参数:")
    @Override
    public String answer(@Param(onlyStart = "a") String name) {
        System.out.println("输出目标:" + name);
        return name;
    }
}
