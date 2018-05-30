/**
 * <html>
 * <body>
 *  <P> Copyright  JasonInternational </p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2018年5月30日 上午10:01:08</p>
 *  <p> Created by Jason </p>
 *  </body>
 * </html>
 */
package cn.ucaner.spring.tiny.beans.config;

/**     
* @Package：cn.ucaner.spring.tiny.beans.config   
* @ClassName：AttributeAccessor   
* @Description：   <p> 元数据操作接口 </p>
* @Author： - Jason   
* @CreatTime：2018年5月30日 上午10:01:08   
* @Modify By：   
* @ModifyTime：  2018年5月30日
* @Modify marker：   
* @version    V1.0
*/
public interface AttributeAccessor {
	
    //设置元数据 
	void setAttribute(String name, Object value);
	
    //获取元数据 
    Object getAttribute(String name);
    
    //删除元数据 
    Object removeAttribute(String name);
    
    //是否含有元数据
    boolean hasAttribute(String name);
    
    //获取元数据的name数组
    String[] attributeNames();
}
