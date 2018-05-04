/**
 * <html>
 * <body>
 *  <P> Copyright 1994-2018 JasonInternational</p>
 *  <p> All rights reserved. - https://github.com/Jasonandy</p>
 *  <p> Created on 2018年5月4日 上午10:39:51</p>
 *  <p> Created by Jason </p>
 *  </body>
 * </html>
 */
package cn.ucaner.maxwell.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* @Package：cn.ucaner.maxwell.annotation   
* @ClassName：Init   
* @Description：   <p> 自定义初始化标签</p>
* @Author： - Jason   
* @CreatTime：2018年5月4日 上午10:36:03   
* @Modify By：   
* @ModifyTime：  2018年5月4日
* @Modify marker：   
* @version    V1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Init {
}
