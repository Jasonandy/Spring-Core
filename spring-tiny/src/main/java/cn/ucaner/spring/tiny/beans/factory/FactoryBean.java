package cn.ucaner.spring.tiny.beans.factory;

/**
* @Package：cn.ucaner.spring.tiny.beans.factory   
* @ClassName：FactoryBean   
* @Description：   <p>FactoryBean  </p>
* @Author： - cwt   
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public interface FactoryBean<T> {
	
	/*
	 * @return whether the exposed object is a singleton
	 */
	boolean  isSingleton();
	
	/**
     * Return an instance (possibly shared or independent) of the object
     * managed by this factory.
     */
    T getObject() throws Exception;

    /**
     * Return the type of object that this FactoryBean creates,
     * or {@code null} if not known in advance.
     * */
    Class<?> getObjectType();	
}
