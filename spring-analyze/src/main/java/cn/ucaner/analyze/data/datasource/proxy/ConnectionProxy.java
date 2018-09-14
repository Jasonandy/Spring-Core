package cn.ucaner.analyze.data.datasource.proxy;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
* @Package：cn.ucaner.analyze.data.datasource.proxy   
* @ClassName：ConnectionProxy   
* @Description：   <p> ConnectionProxy </p>
* @Author： -    
* @CreatTime：2018年5月28日 上午9:12:56   
* @Modify By：   
* @ModifyTime：  2018年5月28日
* @Modify marker：   
* @version    V1.0
 */
public class ConnectionProxy extends ProxyTemplate<Connection> {

	/**
	 * invokePoint 调用-切入点
	 */
    @Override
    public Object invokePoint(Object proxy, Method method, Object[] args) throws Exception {
        if ("prepareStatement".equals(method.getName())) {
            PreparedStatement preparedStatement1 = getTarget().prepareStatement((String) args[0]);
            PreparedStatement preparedStatement2 = getTarget().prepareStatement((String) args[0]);
            getProxyContext().getPreparedStatementList().add(preparedStatement1);
            getProxyContext().getPreparedStatementList().add(preparedStatement2);
            return ProxyFactory.getPreparedStatementProxy(getTarget().prepareStatement((String) args[0]),getProxyContext());
        }
        return method.invoke(getTarget(), args);
    }
}
