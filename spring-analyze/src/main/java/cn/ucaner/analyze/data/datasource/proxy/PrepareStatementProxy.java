package cn.ucaner.analyze.data.datasource.proxy;

import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
* @Package：cn.ucaner.analyze.data.datasource.proxy   
* @ClassName：PrepareStatementProxy   
* @Description：   <p> PrepareStatementProxy </p>
* @Author： -    
* @CreatTime：2018年5月28日 上午9:13:13   
* @Modify By：   
* @ModifyTime：  2018年5月28日
* @Modify marker：   
* @version    V1.0
 */
public class PrepareStatementProxy extends ProxyTemplate<PreparedStatement> {


    @Override
    public Object invokePoint(Object proxy, Method method, Object[] args) throws Exception {
        @SuppressWarnings("unused")
		ResultSet resultSet = null;
        Object result = null;
        for (PreparedStatement preparedStatement : getProxyContext().getPreparedStatementList()) {
//            resultSet = (ResultSet) method.invoke(preparedStatement, args);
//            if (null != resultSet) {
//                getProxyContext().getResultSetList().add(resultSet);
//            }
            result = method.invoke(preparedStatement, args);
        }
//        return ProxyFactory.getResultSetProxy(null, getProxyContext());
        return result;
    }
}
