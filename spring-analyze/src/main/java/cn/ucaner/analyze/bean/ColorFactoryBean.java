package cn.ucaner.analyze.bean;

import org.springframework.beans.factory.FactoryBean;

/**
* @Package：cn.ucaner.analyze.bean   
* @ClassName：ColorFactoryBean   
* @Description：   <p> 创建一个Spring定义的FactoryBean </p>
* @Author： - Jason   
* @CreatTime：2018年7月6日 下午11:08:36   
* @Modify By：   
* @ModifyTime：  2018年7月6日
* @Modify marker：   
* @version    V1.0
 */
public class ColorFactoryBean implements FactoryBean<Color> {

	//返回一个Color对象，这个对象会添加到容器中
	@Override
	public Color getObject() throws Exception {
		System.out.println("ColorFactoryBean...getObject...");
		return new Color();
	}

	@Override
	public Class<?> getObjectType() {
		return Color.class;
	}

	//是单例？
	//true：这个bean是单实例，在容器中保存一份
	//false：多实例，每次获取都会创建一个新的bean；
	@Override
	public boolean isSingleton() {
		return false;
	}

}
