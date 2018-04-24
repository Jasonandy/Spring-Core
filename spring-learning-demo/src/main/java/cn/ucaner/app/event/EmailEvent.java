package cn.ucaner.app.event;

import org.springframework.context.ApplicationEvent;

/**
* @Package：cn.ucaner.app.event   
* @ClassName：EmailEvent   
* @Description：   <p> EmailEvent</p>
* @Author： -    newtonk
* @Modify By：   
* @Modify marker：   
* @version    V1.0
 */
public class EmailEvent extends ApplicationEvent {
	
	private static final long serialVersionUID = 7626614311960858428L;
	private String address;
	private String text;

	public EmailEvent(Object source, String address, String text) {
		super(source);
		this.address = address;
		this.text = text;
	}

	public EmailEvent(Object source) {
		super(source);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
