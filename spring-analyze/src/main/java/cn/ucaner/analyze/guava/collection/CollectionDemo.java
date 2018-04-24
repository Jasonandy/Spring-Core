package cn.ucaner.analyze.guava.collection;

import com.google.common.collect.*;
import jdk.nashorn.internal.ir.annotations.Immutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionDemo {

    public static void main(String[] args) {
//        immutableList();
//        multiSet();
//        multiMap();
        bimap();
    }


    public static void immutableList() {
        List<String> strList = new ArrayList<>();
        strList.add("a");
        strList.add("b");
        strList.add("c");

        List<String> readList = Collections.unmodifiableList(strList);
//        readList.add("d");
        strList.add("d");

        System.out.println(readList);

        List<String> immutableList = ImmutableList.of("a", "b", "c");
        immutableList.add("d");

        System.out.println(immutableList);
    }

    public static void multiSet(){
        String str = "this is a cat eat cat cat";

        String[] strArray = str.split(" ");
        Multiset<String> multiset = HashMultiset.create();
        for (String letter : strArray){
            multiset.add(letter);
        }

        //重复遍历
        for (String letter : multiset){
            System.out.println(letter);
        }

        //不重复遍历
        for (String letter : multiset.elementSet()){
            System.out.println(letter + "," + "count is :" + multiset.count(letter));
        }
    }


    //key可以重复，多个val
    public static void multiMap(){
        Multimap<String,String> multimap = ArrayListMultimap.create();
        multimap.put("a","a1");
        multimap.put("a","a2");
        multimap.put("b","b1");

        for(String key : multimap.keys()){
            System.out.println(key + ":" + multimap.get(key));
        }

    }

    //KEY-VAL 都不能重复，双向hashmap
    public static void bimap(){
        BiMap<String,String> biMap = HashBiMap.create();
        biMap.put("a","a1");
        biMap.put("b","b1");

        System.out.println(biMap.inverse().get("b1"));

    }
}
