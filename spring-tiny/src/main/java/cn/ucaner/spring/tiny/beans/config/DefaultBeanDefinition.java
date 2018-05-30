package cn.ucaner.spring.tiny.beans.config;

/**
* @Package：cn.ucaner.spring.tiny.beans.config   
* @ClassName：DefaultBeanDefinition   
* @Description：   <p> DefaultBeanDefinition </p>
* @Author： - chenwentao    
* @CreatTime：2018年4月27日 上午11:19:33   
* @Modify By：   
* @ModifyTime：  2018年4月27日
* @Modify marker：   
* @version    V1.0
 */
public class DefaultBeanDefinition extends AbstractBeanDefinition {

    @Override
    public String getDescription() {
        return getBeanClass().getName();
    }

    public DefaultBeanDefinition() {

    }

	@Override
	public void setAttribute(String name, Object value) {
		
	}

	@Override
	public Object getAttribute(String name) {
		return null;
	}

	@Override
	public Object removeAttribute(String name) {
		return null;
	}

	@Override
	public boolean hasAttribute(String name) {
		return false;
	}

	@Override
	public String[] attributeNames() {
		return null;
	}

	@Override
	public Object getSource() {
		return null;
	}

}
