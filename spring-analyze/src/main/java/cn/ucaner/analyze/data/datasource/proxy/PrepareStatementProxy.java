package cn.ucaner.analyze.data.datasource.proxy;

import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class PrepareStatementProxy extends ProxyTemplate<PreparedStatement> {


    @Override
    public Object invokePoint(Object proxy, Method method, Object[] args) throws Exception {
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
