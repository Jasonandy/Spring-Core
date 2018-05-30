package cn.ucaner.spring.tiny.enums;

/**
* @Package：cn.ucaner.spring.tiny.enums   
* @ClassName：ConfigurableBeanFactory   
* @Description：   <p> ConfigurableBeanFactory 默认为单例
* bean工厂枚举
* 单例
* 多例
*
* 默认为单例模式.
* </p>
* @Modify By：   
* @Modify marker：   
* @version    V1.0
 */
public enum ConfigurableBeanFactory{
	
	/**
	 *singleton 单例 
	 */
	SCOPE_SINGLETON("singleton"),
	
	/**
	 * prototype
	 */
	SCOPE_PROTOTYPE("prototype");
	
	/**
	 * 域
	 */
	private String BeanScope;
	
	ConfigurableBeanFactory(String BeanScope){
		this.BeanScope=BeanScope;
	}

	public String getBeanScope() {
		return BeanScope;
	}
	
}