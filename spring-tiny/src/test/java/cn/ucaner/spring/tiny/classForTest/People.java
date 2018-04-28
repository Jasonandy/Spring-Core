package cn.ucaner.spring.tiny.classForTest;

/**
* @Package：cn.ucaner.spring.tiny.classForTest   
* @ClassName：People   
* @Description：   <p> People </p>
* @Author： -    
* @Modify By：   
* @ModifyTime：  2018年4月28日
* @Modify marker：   
* @version    V1.0
 */
public class People {

    String name;
    
    Food food;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public String food() {
        
       return food.say();

    }

    @Override
    public String toString() {
        return "我是人";
    }

}
