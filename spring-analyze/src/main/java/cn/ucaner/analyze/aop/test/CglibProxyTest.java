package cn.ucaner.analyze.aop.test;

import cn.ucaner.analyze.aop.bean.ChineseImpl;
import cn.ucaner.analyze.aop.cglib.CglibProxyHelper;
import cn.ucaner.analyze.aop.factory.impl.AudiCarImpl;

/**
* @Package：cn.ucaner.analyze.aop.test   
* @ClassName：CglibProxyTest   
* @Description：   <p> 参考 netty-rpc 动态回调  https://github.com/Jasonandy/Netty-X</p>
* @Author： - Jason   
* @CreatTime：2018年4月24日 下午4:32:57   
* @Modify By：   
* @ModifyTime：  2018年4月24日
* @Modify marker：   
* @version    V1.0
 */
public class CglibProxyTest {

    public static void main(String[] args) {

        CglibProxyHelper cglibProxyHelper = new CglibProxyHelper();
        
       // ChineseImpl chineseImpl = (ChineseImpl)cglibProxyHelper.getProxy(ChineseImpl.class);
        
        AudiCarImpl audiCarImpl = (AudiCarImpl)cglibProxyHelper.getProxy(AudiCarImpl.class);
        
      //  chineseImpl.eat("Apple");
        
        audiCarImpl.echo("Jason");
        
    }
}
//Output
//Call Method public void cn.ucaner.analyze.aop.bean.ChineseImpl.eat(java.lang.String) - args:Parmas[0]=Apple,
//I'm eating  :Apple


//[Before method invoke .]
//Call Method public java.lang.String cn.ucaner.analyze.aop.factory.impl.AudiCarImpl.echo(java.lang.String) - args:Parmas[0]=Jason,
//[After method invoke.]
//The Call Method Result public java.lang.String cn.ucaner.analyze.aop.factory.impl.AudiCarImpl.echo(java.lang.String) - result=Jason Hi cglib Proxy.