package cn.ucaner.analyze.guava.function;

import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import cn.ucaner.analyze.guava.bean.Person;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

public class FilterDemo {

    public static void main(String[] args) {
//        collectionTransform();
        collectionFilter();
    }

    public static void collectionTransform() {
        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();

        person1.setAge(1);
        person1.setName("li");
        person2.setAge(2);
        person3.setAge(3);

        List<Person> userList = Lists.newArrayList(person1, person2, person3);

        Collection<String> result = Collections2.transform(userList, new Function<Person, String>() {
            @Override
            public String apply(Person input) {
                if (StringUtils.isNotEmpty(input.getName())) {
                    return input.getName();
                }
                return "";
            }
        });
        System.out.println(result);
    }

    public static void collectionFilter(){
        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();

        person1.setAge(1);
        person1.setName("li");
        person2.setAge(2);
        person3.setAge(3);

        List<Person> userList = Lists.newArrayList(person1, person2, person3);

        Collection<Person> result = Collections2.filter(userList, new Predicate<Person>() {
            @Override
            public boolean apply(Person input) {
                if(StringUtils.isNotEmpty(input.getName())){
                    return true;
                }else {
                    return false;
                }
            }
        });

        System.out.println(result);
    }

}
