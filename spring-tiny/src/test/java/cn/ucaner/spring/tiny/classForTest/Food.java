package cn.ucaner.spring.tiny.classForTest;

/**
* @Package：cn.ucaner.spring.tiny.classForTest   
* @ClassName：Food   
* @Description：   <p> Food </p>
* @Author： -    
* @Modify By：   
* @ModifyTime：  2018年4月28日
* @Modify marker：   
* @version    V1.0
 */
public class Food {

    private String foodName;

    private int number;
    
    People people;
    
    
    public int getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public String say() {
        return "人要吃饭";
    }
}
