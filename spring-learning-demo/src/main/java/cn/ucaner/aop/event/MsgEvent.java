/**
 * <html>
 * <body>
 *  <P> Copyright 1994-2018 JasonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2018年4月25日 </p>
 *  <p> Created by Jason https://github.com/Jasonandy </p>
 *  </body>
 * </html>
 */
package cn.ucaner.aop.event;

import org.springframework.context.ApplicationEvent;

/**     
 * @Package：cn.ucaner.aop.event   
 * @ClassName：MsgEvent   
 * @Description：   <p> Spring事件</p>
 * @Author： - Jason   
 * @CreatTime：2018年4月25日 下午3:24:02   
 * @Modify By：   
 * @ModifyTime：  2018年4月25日
 * @Modify marker：   
 * @version    V1.0
 */
public class MsgEvent extends ApplicationEvent{

	private static final long serialVersionUID = -2699866138059788077L;
	
	//手机号
	private String phoneNum;
	
	//内容
	private String content;
	
	
	public MsgEvent(Object source) {
		super(source);
	}

	public MsgEvent(Object source, String phoneNum, String content) {
		super(source);
		this.phoneNum = phoneNum;
		this.content = content;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}

	
	
}
