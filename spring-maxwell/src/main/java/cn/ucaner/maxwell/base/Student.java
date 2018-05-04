package cn.ucaner.maxwell.base;

/**
* @Package：cn.ucaner.maxwell.base   
* @ClassName：Student   
* @Description：   <p> Student </p>
* @Author： - Jason    
* @CreatTime：2018年5月4日 上午10:43:54   
* @Modify By：   
* @ModifyTime：  2018年5月4日
* @Modify marker：   
* @version    V1.0
 */
public class Student extends BaseStudent {

	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

    public Student(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public Student() {
    }

    @Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
}
