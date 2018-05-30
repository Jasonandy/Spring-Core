package cn.ucaner.analyze.data.datasource.bean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
* @Package：cn.ucaner.analyze.data.datasource.bean   
* @ClassName：ProxyContext   
* @Description：   <p> ProxyContext </p>
* @Author： -    
* @CreatTime：2018年5月28日 上午9:12:38   
* @Modify By：   
* @ModifyTime：  2018年5月28日
* @Modify marker：   
* @version    V1.0
 */
public class ProxyContext {

    private List<ResultSet> resultSetList;

    private List<PreparedStatement> preparedStatementList;

	public List<ResultSet> getResultSetList() {
		return resultSetList;
	}

	public void setResultSetList(List<ResultSet> resultSetList) {
		this.resultSetList = resultSetList;
	}

	public List<PreparedStatement> getPreparedStatementList() {
		return preparedStatementList;
	}

	public void setPreparedStatementList(
			List<PreparedStatement> preparedStatementList) {
		this.preparedStatementList = preparedStatementList;
	}
    
}
