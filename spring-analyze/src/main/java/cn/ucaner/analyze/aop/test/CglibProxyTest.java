package cn.ucaner.analyze.aop.test;


import cn.ucaner.analyze.aop.bean.ChineseImpl;
import cn.ucaner.analyze.aop.cglib.CglibProxyDemo;

public class CglibProxyTest {

    public static void main(String[] args) {

        CglibProxyDemo cglibProxy = new CglibProxyDemo();
        ChineseImpl chineseProxy = (ChineseImpl) cglibProxy.getProxy(ChineseImpl.class);

        chineseProxy.sayHello("hello CGLIB");

    }
}
