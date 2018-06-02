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
	
	/**
	 * @Description: 设置元数据 
	 * @param name
	 * @param value void
	 * @Autor: JASON - jasonandy@hotmail.com
	 */
	void setAttribute(String name, Object value);
	
	/**
	 * @Description: 获取元数据  
	 * @param name
	 * @return Object
	 * @Autor: JASON - jasonandy@hotmail.com
	 */
    Object getAttribute(String name);
    
    /**
     * @Description: 删除元数据 
     * @param name
     * @return Object
     * @Autor: JASON - jasonandy@hotmail.com
     */
    Object removeAttribute(String name);
    
    /**
     * @Description: 是否含有元数据 
     * @param name
     * @return boolean
     * @Autor: jason - jasonandy@hotmail.com
     */
    boolean hasAttribute(String name);
    
    /**
     * @Description: 获取元数据的name数组
     * @return String[]
     * @Autor:Jason - jasonandy@hotmail.com
     */
    String[] attributeNames();
}
