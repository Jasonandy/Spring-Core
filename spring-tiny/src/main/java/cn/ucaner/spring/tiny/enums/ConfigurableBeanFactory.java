package cn.ucaner.spring.tiny.enums;

/**
* @Package：cn.ucaner.spring.tiny.enums   
* @ClassName：ConfigurableBeanFactory   
* @Description：   <p> ConfigurableBeanFactory 默认为单例</p>
* @Modify By：   
* @Modify marker：   
* @version    V1.0
 */
public enum ConfigurableBeanFactory{
	
	SCOPE_SINGLETON("singleton"),
	SCOPE_PROTOTYPE("prototype");
	
	private String BeanScope;
	
	ConfigurableBeanFactory(String BeanScope){
		this.BeanScope=BeanScope;
	}

	public String getBeanScope() {
		return BeanScope;
	}
}