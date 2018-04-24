package cn.ucaner.analyze.data.mybatis.entity;

import java.util.Date;

public class UserEntity {

    Long id;

    String userName;

    String sex;

    Long age;

    String email;

    String phone;

    Long version;

    Date lastModifyTime;

    Date createTime;

	/**  
	 * @return id  
	 */
	public Long getId() {
		return id;
	}

	/**  
	 * @param paramtheparamthe{bare_field_name} to set  
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**  
	 * @return userName  
	 */
	public String getUserName() {
		return userName;
	}

	/**  
	 * @param paramtheparamthe{bare_field_name} to set  
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
	public Long getAge() {
		return age;
	}

	/**  
	 * @param paramtheparamthe{bare_field_name} to set  
	 */
	public void setAge(Long age) {
		this.age = age;
	}

	/**  
	 * @return email  
	 */
	public String getEmail() {
		return email;
	}

	/**  
	 * @param paramtheparamthe{bare_field_name} to set  
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**  
	 * @return phone  
	 */
	public String getPhone() {
		return phone;
	}

	/**  
	 * @param paramtheparamthe{bare_field_name} to set  
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**  
	 * @return version  
	 */
	public Long getVersion() {
		return version;
	}

	/**  
	 * @param paramtheparamthe{bare_field_name} to set  
	 */
	public void setVersion(Long version) {
		this.version = version;
	}

	/**  
	 * @return lastModifyTime  
	 */
	public Date getLastModifyTime() {
		return lastModifyTime;
	}

	/**  
	 * @param paramtheparamthe{bare_field_name} to set  
	 */
	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	/**  
	 * @return createTime  
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**  
	 * @param paramtheparamthe{bare_field_name} to set  
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", userName=" + userName + ", sex="
				+ sex + ", age=" + age + ", email=" + email + ", phone="
				+ phone + ", version=" + version + ", lastModifyTime="
				+ lastModifyTime + ", createTime=" + createTime + "]";
	}

}
