package cn.ucaner.analyze.data.datasource.proxy;


import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
* @Package：cn.ucaner.analyze.data.datasource.proxy   
* @ClassName：ResultSetProxy   
* @Description：   <p> ResultSetProxy 结果集合代理</p>
* @Author： - Jason   
* @CreatTime：2018年9月14日 下午12:34:54   
* @Modify By：   
* @ModifyTime：  2018年9月14日
* @Modify marker：   
* @version    V1.0
 */
public class ResultSetProxy extends ProxyTemplate<ResultSet> {

    private int index = 0;

    @Override
    public Object invokePoint(Object proxy, Method method, Object[] args) throws Exception {
        if("next".equals(method.getName())){
            return getResult();
        }
        return method.invoke(getTarget(), args);
    }

    private Object getResult() throws SQLException {
        if (index < getProxyContext().getResultSetList().size()) {
            setTarget(getProxyContext().getResultSetList().get(index));
            boolean ret =  getProxyContext().getResultSetList().get(index).next();
            if (ret) {
                return ret;
            } else {
                index++;
                return getResult();
            }
        }
        return false;
    }

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
    
    
}
