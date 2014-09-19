package org.easywechat.msg.req;

import org.easywechat.util.MessageBuilder;

/**
 * 扫描带参数二维码事件
 */
public final class QrCodeEvent extends BaseEvent {

	private String eventKey;// 事件KEY值
	private String ticket;// 二维码的ticket，可用来换取二维码图片

	/**
	 * 得到事件KEY值
	 */
	public String getEventKey() {
		return eventKey;
	}

	/**
	 * 得到二维码的ticket，可用来换取二维码图片
	 */
	public String getTicket() {
		return ticket;
	}

	public QrCodeEvent(String eventKey, String ticket) {
		super();
		this.eventKey = eventKey;
		this.ticket = ticket;
	}

	@Override
	public String toXml() {
		MessageBuilder mb = new MessageBuilder(super.toString());
		mb.addData("EventKey", eventKey);
		mb.addData("Ticket", ticket);
		return mb.toString();
	}

	@Override
	public String toString() {
		return "QrCodeEvent [eventKey=" + eventKey + ", ticket=" + ticket
				+ ", toUserName=" + toUserName + ", fromUserName="
				+ fromUserName + ", createTime=" + createTime + ", msgType="
				+ msgType + "]";
	}

}
