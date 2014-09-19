package org.easywechat.msg.req;

import org.easywechat.util.MessageBuilder;

/**
 * 自定义菜单事件
 */
public final class MenuEvent extends BaseEvent {

	private String eventKey;// 事件KEY值，与自定义菜单接口中KEY值对应

	/**
	 * 得到事件KEY值，与自定义菜单接口中KEY值对应
	 */
	public String getEventKey() {
		return eventKey;
	}

	@Override
	/**
	 * 得到事件类型，有CLICK和VIEW两种
	 */
	public String getEvent() {
		return super.getEvent();
	}

	public MenuEvent(String eventKey) {
		super();
		this.eventKey = eventKey;
	}

	@Override
	public String toXml() {
		MessageBuilder mb = new MessageBuilder(super.toString());
		mb.addData("EventKey", eventKey);
		return mb.toString();
	}

	@Override
	public String toString() {
		return "MenuEvent [eventKey=" + eventKey + ", toUserName=" + toUserName
				+ ", fromUserName=" + fromUserName + ", createTime="
				+ createTime + ", msgType=" + msgType + "]";
	}

}
