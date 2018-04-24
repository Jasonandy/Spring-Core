package cn.ucaner.annotation;

import java.lang.reflect.Field;

/**
* @Package：cn.ucaner.annotation   
* @ClassName：MyTest   
* @Description：   <p> TODO</p>
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
    @Try(color="白色")
    private static String color;

    public static void main(String[] args) throws Exception {
        Class c = Class.forName("com.newtonk.annotation.MyTest");
//       boolean result =  c.isAnnotationPresent(Try.class);
//        System.out.println(result);
        Field[] field = c.getDeclaredFields();
        for (Field field1 : field) {
            boolean result =  field1.isAnnotationPresent(Try.class);
            System.out.println(result);
            if (result) {
                Try a = field1.getAnnotation(Try.class);
                System.out.println(a.color());
            }
        }
    }
}
