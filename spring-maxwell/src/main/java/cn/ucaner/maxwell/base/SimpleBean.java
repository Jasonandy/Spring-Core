package cn.ucaner.maxwell.base;

import cn.ucaner.maxwell.annotation.Init;

/**
 * SimpleBean
 *
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
