package cn.ucaner.spring.tiny.beans.factory;

public abstract class AbstractFactoryBean<T> implements FactoryBean<T> {
   
	private boolean singleton = true;

	@Override
	public boolean isSingleton() {
		return singleton;
	}

}
