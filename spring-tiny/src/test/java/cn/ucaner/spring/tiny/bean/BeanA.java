package cn.ucaner.spring.tiny.bean;

import cn.ucaner.spring.tiny.classForTest.Food;
import cn.ucaner.spring.tiny.classForTest.People;

/**
* @Package：cn.ucaner.spring.tiny.bean   
* @ClassName：BeanA   
* @Description：   <p> BeanA</p>
* @Author： -    
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public class BeanA implements jiekou {
    
    private People people;
    
    private Food food;
    
    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People p) {
        this.people = p;
    }

    public String name;

    public String toString() {
        // TODO Auto-generated method stub
        return "BeanA测试成功" + "属性名：" + name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String aaa() {
        System.out.println("动态代理");
        return "动态代理";
    }
}
