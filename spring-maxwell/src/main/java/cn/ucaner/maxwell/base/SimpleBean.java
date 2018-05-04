package cn.ucaner.maxwell.base;

import cn.ucaner.maxwell.annotation.Init;

/**
* @Package：cn.ucaner.maxwell.base   
* @ClassName：SimpleBean   
* @Description：   <p> SimpleBean </p>
* @Author： - Jason    
* @CreatTime：2018年5月4日 上午10:43:21   
* @Modify By：   
* @ModifyTime：  2018年5月4日
* @Modify marker：   
* @version    V1.0
 */
public class SimpleBean {

	private Student student;

    public SimpleBean() {}
	
	public SimpleBean(Student student) {
		this.student = student;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void send() {
		System.out.println("I am send method from SimpleBean!");
	}

    @Init
    public void init() {
        System.out.println("Init!");
    }
	
}
