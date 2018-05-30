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
* @ClassName：BeanMetadataElement   
* @Description：   <p> 接口：用于承载bean对象 </p>
* @Author： - Jason   
* @CreatTime：2018年5月30日 上午10:03:30   
* @Modify By：   
* @ModifyTime：  2018年5月30日
* @Modify marker：   
* @version    V1.0
*/
public interface BeanMetadataElement {
	
	//获取当前元素的配置源bean对象
    Object getSource();

}
