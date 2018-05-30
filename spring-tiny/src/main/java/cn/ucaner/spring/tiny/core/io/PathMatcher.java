/**
 * <html>
 * <body>
 *  <P> Copyright JasonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2018年5月15日 下午12:03:01</p>
 *  <p> Created by wubin</p>
 *  </body>
 * </html>
 */
package cn.ucaner.spring.tiny.core.io;

import java.util.Comparator;
import java.util.Map;

/**     
* @Package：cn.ucaner.spring.tiny.core.io   
* @ClassName：PathMatcher   
* @Description：   <p> PathMatcher Spring 匹配器接口</p>
* @Author： - Jason   
* @CreatTime：2018年5月15日 下午12:03:01   
* @Modify By：   
* @ModifyTime：  2018年5月15日
* @Modify marker：   
* @version    V1.0
*/
public interface PathMatcher {
	
	boolean isPattern(String path);

	boolean match(String pattern, String path);

	boolean matchStart(String pattern, String path);

	String extractPathWithinPattern(String pattern, String path);

	Map<String, String> extractUriTemplateVariables(String pattern, String path);

	Comparator<String> getPatternComparator(String path);

	String combine(String pattern1, String pattern2);

}
