package cn.ucaner.tang;

import java.util.Arrays;

/**
* @Package：cn.ucaner.tang   
* @ClassName：TestA   
* @Description：   <p> TestA </p>
* @Author： -    
* @Modify By：   
* @Modify marker：   
* @version    V1.0
 */
public class TestA {
    public static void main(String[] args) {
        String[] i =new String[1000000];
        for(int num=0;num<1000000;num++)
            i[num] = num+"";
//        System.out.println(Arrays.toString(i));

        Long time = System.currentTimeMillis();//start
        for (String target: i) {
         if(target.equals("80000")) break;
        }
        System.out.println(System.currentTimeMillis()- time+"---for循环时间");

        String many = Arrays.toString(i);
        String regex = "\\D800000\\D";
        boolean flag = many.matches(regex);
        System.out.println(System.currentTimeMillis()- time+"----正则匹配时间");
    }
}
