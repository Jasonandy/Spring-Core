package cn.ucaner.annotation.best;

/**
* @Package：cn.ucaner.annotation.best   
* @ClassName：AllTest   
* @Description：   <p> AllTest </p>
* @Author： - Jason   
* @Modify By：   
* @Modify marker：   
* @version    V1.0
 */
public class AllTest {
	
    public static void main(String[] args) {
    	
    	//注解校验参数
        Exam max = new Daili(new Max());
       
        max.answer("max.answer");
        
        max.answer("answer");
    }
}
//Output
//参数值不合法

//输出目标:方法附加值. 真正参数:answer [a 开头]