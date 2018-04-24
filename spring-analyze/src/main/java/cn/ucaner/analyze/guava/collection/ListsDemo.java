package cn.ucaner.analyze.guava.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

public class ListsDemo {

    public static void main(String[] args) {

        System.out.println("### Lists ###");
        ArrayList<String> arrayList = Lists.newArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("AC");
        arrayList.add("ABC");
        arrayList.add("C");
        arrayList.add("BAC");

//        System.out.println(arrayList);

        LinkedList<String> linkedList = Lists.newLinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        System.out.println(linkedList);

//        System.out.println(Lists.reverse(arrayList));   //翻转集合元素的顺序
//        System.out.println(Lists.reverse(linkedList));

//        System.out.println(Lists.partition(arrayList, 2)); //一个集合内再分成n个子集合

        Collection<String> filterList = Collections2.filter(arrayList,str -> str.contains("A"));
        filterList.forEach(str ->System.out.println(str));

//        List<Person> userList = Lists.newArrayList(person1, person2, person3);
//
//        Collection<Person> result = Collections2.filter(userList, new Predicate<Person>() {
//            @Override
//            public boolean apply(Person input) {
//                if(StringUtils.isNotEmpty(input.getName())){
//                    return true;
//                }else {
//                    return false;
//                }
//            }
//        });

    }

}
