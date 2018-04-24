package cn.ucaner.analyze.guava.bean;

public class Person {

    private String name;

    private String sex;

    private int age;

	/**  
	 * @return name  
	 */
	public String getName() {
		return name;
	}

	/**  
	 * @param paramtheparamthe{bare_field_name} to set  
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**  
	 * @return sex  
	 */
	public String getSex() {
		return sex;
	}

	/**  
	 * @param paramtheparamthe{bare_field_name} to set  
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**  
	 * @return age  
	 */
	public int getAge() {
		return age;
	}

	/**  
	 * @param paramtheparamthe{bare_field_name} to set  
	 */
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", sex=" + sex + ", age=" + age + "]";
	}
    
}
