package cn.ucaner.maxwell.test.proxy;

import java.lang.reflect.Proxy;

/**
 * 测试JDK动态代理.
 *
 */
public class JDKProxy {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        UserService proxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                new Class[]{UserService.class}, new Handler(userService));
        proxy.printName();
    }

}
//outputs 

//Method printName is proxyed.
//Name is xxxx
//Age: 18