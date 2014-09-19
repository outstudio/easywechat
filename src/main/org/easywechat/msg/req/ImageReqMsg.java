package org.easywechat.msg.req;

import org.easywechat.util.MessageBuilder;

/**
 * 接收到的图片消息
 */
public final class ImageReqMsg extends BaseReqMsg {

	private String picUrl;// 图片链接
	private String mediaId;// 图片消息媒体id，可以调用多媒体文件下载接口拉取数据

	/**
	 * 得到图片链接
	 */
	public String getPicUrl() {
		return picUrl;
	}

	/**
	 * 得到图片消息媒体id，可以调用多媒体文件下载接口拉取数据
	 */
	public String getMediaId() {
		return mediaId;
	}

	public ImageReqMsg(String picUrl, String mediaId) {
		super();
		this.picUrl = picUrl;
		this.mediaId = mediaId;
		setMsgType(ReqType.IMAGE);
	}

	@Override
	public String toXml() {
		MessageBuilder mb = new MessageBuilder(super.toXml());
		mb.addData("MsgType", ReqType.IMAGE);
		mb.addData("PicUrl", picUrl);
		mb.addData("MediaId", mediaId);
		mb.addTag("MsgId", msgId);
		mb.surroundWith("xml");
		return mb.toString();
	}

	@Override
	public String toString() {
		return "ImageReqMsg [picUrl=" + picUrl + ", mediaId=" + mediaId
				+ ", toUserName=" + toUserName + ", fromUserName="
				+ fromUserName + ", createTime=" + createTime + ", msgType="
				+ msgType + ", msgId=" + msgId + "]";
	}

}
