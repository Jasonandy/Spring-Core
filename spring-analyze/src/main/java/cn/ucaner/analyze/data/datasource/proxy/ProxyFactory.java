package cn.ucaner.analyze.data.datasource.proxy;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.ucaner.analyze.data.datasource.bean.ProxyContext;

public class ProxyFactory {


	public static Connection getConnectionProxy(Connection con, ProxyContext proxyContext) {
		ConnectionProxy proxy = new ConnectionProxy();
		proxy.setTarget(con);
		proxy.setProxyContext(proxyContext);
		Connection proxyInstance = (Connection) Proxy.newProxyInstance(
				Connection.class.getClassLoader(),
				new Class[] { Connection.class }, proxy);
		return proxyInstance;
	}

//	/**
//	 * 获取Statement代理
//	 *
//	 * @param statement
//	 * @return
//	 */
//	public static Statement getStatementProxy(Statement statement,
//			DALContext dalContext) {
//		DALStatementProxy proxy = new DALStatementProxy();
//		proxy.warp(statement);
//		proxy.setDalContext(dalContext);
//		Statement proxyInstance = (Statement) Proxy.newProxyInstance(
//				Statement.class.getClassLoader(),
//				new Class[] { Statement.class }, proxy);
//		DALStatementStatus dalStatus = new DALStatementStatus();
//		dalContext.setStatus(proxyInstance, dalStatus);
//		if (statement == null) {
//			dalStatus
//					.setInvocationRecorder(new InvocationRecorder("Statement"));
//		}
//		return proxyInstance;
//	}


	public static PreparedStatement getPreparedStatementProxy(
			PreparedStatement preparedStatement,ProxyContext proxyContext) {
		PrepareStatementProxy proxy = new PrepareStatementProxy();
		proxy.setTarget(preparedStatement);
		proxy.setProxyContext(proxyContext);
		PreparedStatement proxyInstance = (PreparedStatement) Proxy.newProxyInstance(
				PreparedStatement.class.getClassLoader(),
				new Class[] { PreparedStatement.class }, proxy);
		return proxyInstance;
	}


	public static ResultSet getResultSetProxy(ResultSet resultSet,ProxyContext proxyContext) {
		ResultSetProxy proxy = new ResultSetProxy();
		proxy.setTarget(resultSet);
		proxy.setProxyContext(proxyContext);
		ResultSet proxyInstance = (ResultSet) Proxy.newProxyInstance(
				ResultSet.class.getClassLoader(),
				new Class[] { ResultSet.class }, proxy);
		return proxyInstance;
	}

}
