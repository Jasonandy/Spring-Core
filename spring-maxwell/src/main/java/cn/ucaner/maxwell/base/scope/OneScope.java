package cn.ucaner.maxwell.base.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import cn.ucaner.maxwell.base.Student;

/**
* @Package：cn.ucaner.maxwell.base.scope   
* @ClassName：OneScope   
* @Description：   <p> OneScope
* {@link org.springframework.beans.factory.config.Scope}
* 简单实现，每调用一次变返回一个新的对象
* </p>
* @Author： - Jason    
* @CreatTime：2018年5月4日 上午10:41:47   
* @Modify By：   
* @ModifyTime：  2018年5月4日
* @Modify marker：   
* @version    V1.0
 */
public class OneScope implements Scope {

    private int index = 0;

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        System.out.println("get被调用");
        return new Student("skywalker-" + (index++), index);
    }

    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }

}
