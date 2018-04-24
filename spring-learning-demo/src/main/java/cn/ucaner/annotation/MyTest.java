package cn.ucaner.annotation;

import java.lang.reflect.Field;

/**
* @Package：cn.ucaner.annotation   
* @ClassName：MyTest   
* @Description：   <p> MyTest </p>
* </br> https://github.com/759796385/spring-leanring-demo 
* </p>
* @Author： - newtonk    
* @CreatTime：2018年4月24日 上午10:56:33   
* @Modify By：   
* @ModifyTime：  2018年4月24日
* @Modify marker：   
* @version    V1.0
 */
public class MyTest {
	
    @Try(color="Red")
    private static String color;

    public static void main(String[] args) throws Exception {
        Class<?> c = Class.forName(MyTest.class.getName());
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            boolean result =  field.isAnnotationPresent(Try.class);
            System.out.println(result);
            if (result) {
                Try a = field.getAnnotation(Try.class);
                System.out.println(a.color());
            }
        }
    }
}
