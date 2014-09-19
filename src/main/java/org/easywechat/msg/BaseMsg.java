package org.easywechat.msg;

import org.easywechat.util.MessageBuilder;

public class BaseMsg {

	// 接收方帐号（收到的OpenID）
	private String toUserName;
	// 开发者微信号
	private String fromUserName;
	// 消息创建时间
	private long createTime;
	// 消息类型
	private String msgType;

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public BaseMsg() {
	}

	/**
	 * 将Msg对象转成XML格式
	 */
	public String toXml() {
		// 159 = 106 + 28(ToUserName) + 15(FromUserName) + 10(CreateTime)
		MessageBuilder builder = new MessageBuilder(159);
		builder.addData("ToUserName", toUserName);
		builder.addData("FromUserName", fromUserName);
		builder.addTag("CreateTime",
				String.valueOf(System.currentTimeMillis() / 1000));
		return builder.toString();
	}

	@Override
	public String toString() {
		return toXml();
	}

}
