package cn.ucaner.analyze.data.datasource.bean;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.sql.DataSource;

import cn.ucaner.analyze.data.datasource.proxy.ProxyFactory;

/**
* @Package：cn.ucaner.analyze.data.datasource.bean   
* @ClassName：ProxyDataSource   
* @Description：   <p> ProxyDataSource </p>
* @Author： -    
* @CreatTime：2018年5月28日 上午9:12:47   
* @Modify By：   
* @ModifyTime：  2018年5月28日
* @Modify marker：   
* @version    V1.0
 */
public class ProxyDataSource implements DataSource{

    private DataSource dataSource;

	private PrintWriter logWriter;

	@Override
    public Connection getConnection() throws SQLException {
        ProxyContext proxyContext = new ProxyContext();
        proxyContext.setResultSetList(new ArrayList<>());
        proxyContext.setPreparedStatementList(new ArrayList<>());
        logWriter.print("yes , this is vwery good do you know how to do it.");
        return ProxyFactory.getConnectionProxy(dataSource.getConnection(),proxyContext);
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
    
    
}
