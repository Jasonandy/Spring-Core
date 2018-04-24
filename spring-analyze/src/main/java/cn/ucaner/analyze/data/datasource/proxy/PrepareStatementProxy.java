package cn.ucaner.analyze.data.datasource.proxy;

import com.mysql.jdbc.ResultSetImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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
