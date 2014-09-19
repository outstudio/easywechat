package org.easywechat.msg;

import org.easywechat.util.MessageBuilder;

/**
 * 用于回复的图片消息
 */
public class ImageMsg extends BaseMsg {

	private String mediaId;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public ImageMsg() {
	}

	public ImageMsg(String mediaId) {
		this.mediaId = mediaId;
	}

	@Override
	public String toXml() {
		MessageBuilder mb = new MessageBuilder(super.toXml());
		mb.addData("MsgType", RespType.IMAGE);
		mb.append("<Image>\n");
		mb.addData("MediaId", mediaId);
		mb.append("</Image>\n");
		mb.surroundWith("xml");
		return mb.toString();
	}

	@Override
	public String toString() {
		return "ImageMsg [mediaId=" + mediaId + "]";
	}

}
