package cn.ucaner.analyze.data.datasource.bean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

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
