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
 * @Description：   <p> Spring事件
 * bean 与 bean之间传递消息
 * 一个bean处理完了希望其余一个接着处理.
 * 这时我们就需要其余的一个bean监听当前bean所发送的事件.
 * 
 * 1.先自定义事件：你的事件需要继承 ApplicationEvent
 * 2.定义事件监听器: 需要实现 ApplicationListener
 * 3.使用容器对事件进行发布
 * 
 * </p>
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
	
	
	/**
	* MsgEvent. 因为父类ApplicationEvent中没有默认的构造方法，所以子类必须重载构造函数
	* @param source enventObject  protected transient Object  source
	 */
	public MsgEvent(Object source) {
		super(source);
	}

	/**
	* MsgEvent. 因为父类ApplicationEvent中没有默认的构造方法，所以子类必须重载构造函数
	* @param source
	* @param phoneNum
	* @param content
	 */
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
