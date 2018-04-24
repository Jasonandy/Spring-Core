package cn.ucaner.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
* @Package：cn.ucaner.hashmap   
* @ClassName：HashMapTest   
* @Description：   <p> 1.7 的hashMap </p>
* @Author： - tq   
* @CreatTime：2016/10/15 0015
* @Modify By：   
* @Modify marker：   
* @version    V1.0
 */
public class HashMapTest {
	
    public static void main(String[] args) {
        Map<HashKey,Integer> map = new HashMap();
        long start = System.currentTimeMillis();
        //
        for(int i=0 ;i<50000;i++){
            map.put(new HashKey(i+""),i);
        }
        long insert = System.currentTimeMillis();
        System.out.println("加入耗时"+(insert-start));
        //get 最后一个值
        map.get(new HashKey(0+""));
        long end = System.currentTimeMillis();
        System.out.println("查询耗时"+(end-insert)+" ms");
    }
}
