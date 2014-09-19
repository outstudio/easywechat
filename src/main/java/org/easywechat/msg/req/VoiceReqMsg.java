package org.easywechat.msg.req;

import org.easywechat.util.MessageBuilder;

/**
 * 接收到的语音消息
 */
public final class VoiceReqMsg extends BaseReqMsg {

	private String mediaId;// 语音消息媒体id，可以调用多媒体文件下载接口拉取数据
	private String format;// 语音格式，如amr，speex等

	private String recognition;// 语音识别结果，UTF8编码

	/**
	 * 语音消息媒体id，可以调用多媒体文件下载接口拉取数据
	 */
	public String getMediaId() {
		return mediaId;
	}

	/**
	 * 得到语音格式，如amr、speex等
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * 得到语音识别结果，UTF8编码<br>
	 * 注意：如果未开通语音识别接口，则返回null
	 */
	public String getRecognition() {
		return recognition;
	}

	public VoiceReqMsg(String mediaId, String format, String recognition) {
		super();
		this.mediaId = mediaId;
		this.format = format;
		this.recognition = recognition;
		setMsgType(ReqType.VOICE);
	}

	@Override
	public String toXml() {
		MessageBuilder mb = new MessageBuilder(super.toXml());
		mb.addData("MsgType", ReqType.VOICE);
		mb.addData("MediaId", mediaId);
		mb.addData("Format", format);
		mb.addTag("MsgId", msgId);
		mb.surroundWith("xml");
		return mb.toString();
	}

	@Override
	public String toString() {
		return "VoiceReqMsg [mediaId=" + mediaId + ", format=" + format
				+ ", recognition=" + recognition + ", msgId=" + msgId
				+ ", toUserName=" + toUserName + ", fromUserName="
				+ fromUserName + ", createTime=" + createTime + ", msgType="
				+ msgType + "]";
	}

}
