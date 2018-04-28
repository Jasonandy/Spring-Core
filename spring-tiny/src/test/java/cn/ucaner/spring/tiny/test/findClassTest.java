package cn.ucaner.spring.tiny.test;

/**
* @Package：cn.ucaner.spring.tiny.test   
* @ClassName：findClassTest   
* @Description：   <p> findClassTest </p>
* @Author： -    
* @Modify By：   
* @ModifyTime：  2018年4月28日
* @Modify marker：   
* @version    V1.0
 */
public class findClassTest {

    public static void main(String[] args) {

        @SuppressWarnings("unused")
        String a = new String();
        try {
            Class<?> cl = Class.forName("java.lang.String");
            System.out.println(cl.getSimpleName());
        } catch (ClassNotFoundException e) {
            System.out.println("没找到");
        }

    }

}
