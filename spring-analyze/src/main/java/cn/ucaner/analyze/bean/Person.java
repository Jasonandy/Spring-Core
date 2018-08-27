package cn.ucaner.analyze.bean;

import org.springframework.beans.factory.annotation.Value;

/**
* @Package：cn.ucaner.analyze.bean   
* @ClassName：Person   
* @Description：   <p> Person </p>
* @Author： - Jason   
* @CreatTime：2018年7月6日 下午11:10:58   
* @Modify By：   
* @ModifyTime：  2018年7月6日
* @Modify marker：   
* @version    V1.0
 */
public class Person {
	
	//使用@Value赋值；
	//1、基本数值
	//2、可以写SpEL； #{}
	//3、可以写${}；取出配置文件【properties】中的值（在运行环境变量里面的值）
	
	@Value("张三")
	private String name;
	
	
	@Value("#{20-2}") //SpEl表达式 
	private Integer age;
	
	@Value("${person.nickName}")  //占位符取出数据
	private String nickName;
	
	
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Person() {
		super();
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", nickName=" + nickName + "]";
	}

}
