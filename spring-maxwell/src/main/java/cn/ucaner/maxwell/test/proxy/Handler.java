package cn.ucaner.maxwell.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
* @Package：cn.ucaner.maxwell.test.proxy   
* @ClassName：Handler   
* @Description：   <p> {@link java.lang.reflect.InvocationHandler}实现. 
* https://www.cnblogs.com/LCcnblogs/p/6823982.html
* </p>
* @Author： - Jason    
* @CreatTime：2018年5月4日 上午10:45:58   
* @Modify By：   
* @ModifyTime：  2018年5月4日
* @Modify marker：   
* @version    V1.0
 */
public class Handler implements InvocationHandler {

	/*
	 * 目标对象
	 */
    private final Object target;

    public Handler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name = method.getName();
        System.out.println("[MaxWell-Handler]Method " + name + " is proxyed.");
        return method.invoke(target, args);
    }


}
