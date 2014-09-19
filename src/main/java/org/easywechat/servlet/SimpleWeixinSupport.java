package org.easywechat.servlet;

import org.easywechat.msg.BaseMsg;
import org.easywechat.msg.TextMsg;
import org.easywechat.msg.req.BaseEvent;
import org.easywechat.msg.req.BaseReqMsg;
import org.easywechat.msg.req.ImageReqMsg;
import org.easywechat.msg.req.LocationReqMsg;
import org.easywechat.msg.req.MenuEvent;
import org.easywechat.msg.req.TextReqMsg;
import org.easywechat.msg.req.VideoReqMsg;
import org.easywechat.msg.req.VoiceReqMsg;

/**
 * 该类提供了一系列接收并响应消息的简便方法，使用者不需要处理XxxMsgReq对象<br>
 * 如果需要获取消息的FromUserName,CreateTime,MagId等属性，请不要使用该类，使用WeixinServletSupport
 */
@SuppressWarnings("serial")
public abstract class SimpleWeixinSupport extends WeixinServletSupport {

	/**
	 * 接收用户发送的文本消息，并以文本消息回应<br>
	 * 注意：该方法为“仅用文本消息回应文本消息”提供便利， 如果可能需要用其他类型的消息去回应文本消息，则不能重写该方法，应该重写onText方法<br>
	 * 
	 * 重写该方法会导致onText方法失效
	 * 
	 * @param content
	 *            用户发送的消息
	 * 
	 * @return 回应用户的文本
	 */
	protected String handleTextWithText(String content) {
		return null;
	}

	/**
	 * 回应用户发送的文本消息
	 * 
	 * @param content
	 *            用户发送的消息
	 * 
	 * @return 回应用户的消息
	 */
	protected BaseMsg onText(String content) {
		return null;
	}

	/**
	 * 回应用户发送的图片消息
	 * 
	 * @param mediaId
	 *            图片消息媒体id
	 * @param picUrl
	 *            图片链接
	 * 
	 * @return 回应用户的消息
	 */
	protected BaseMsg onImage(String mediaId, String picUrl) {
		return null;
	}

	/**
	 * 回应用户发送的语音消息
	 * 
	 * @param mediaId
	 *            语音消息媒体id
	 * @param format
	 *            语音格式
	 * 
	 * @return 回应用户的消息
	 */
	protected BaseMsg onVoice(String mediaId, String format) {
		return null;
	}

	/**
	 * 回应用户发送的视频消息
	 * 
	 * @param mediaId
	 *            视频消息媒体id
	 * @param thumbMediaId
	 *            视频消息缩略图的媒体id
	 * 
	 * @return 回应用户的消息
	 */
	protected BaseMsg onVideo(String mediaId, String thumbMediaId) {
		return null;
	}

	/**
	 * 回应用户发送的地理位置消息
	 * 
	 * @param locationX
	 *            纬度
	 * @param locationY
	 *            经度
	 * @param scale
	 *            地图缩放大小
	 * @param label
	 *            地理位置信息
	 * 
	 * @return 回应用户的消息
	 */
	protected BaseMsg onLocation(double locationX, double locationY, int scale,
			String label) {
		return null;
	}

	/**
	 * 回应用户发送的链接消息
	 * 
	 * @param title
	 *            消息标题
	 * @param description
	 *            消息描述
	 * @param url
	 *            消息链接
	 * 
	 * @return 回应用户的消息
	 */
	protected BaseMsg onLink(String title, String description, String url) {
		return null;
	}

	/**
	 * 回应菜单点击事件
	 * 
	 * @param eventKey
	 *            事件KEY值，与自定义菜单接口中KEY值对应
	 * 
	 * @return 回应用户的消息
	 */
	private BaseMsg onMenuClick(String eventKey) {
		return null;
	}

	@Override
	protected final BaseMsg handleTextMsg(TextReqMsg msg) {

		String reqText = msg.getContent();

		String respText = handleTextWithText(reqText);
		if (respText != null) {// handleTextWithText方法被重写
			return new TextMsg(respText);
		}

		BaseMsg respMsg = onText(reqText);
		return responseMsgOrDefault(respMsg, msg);
	}

	@Override
	protected final BaseMsg handleImageMsg(ImageReqMsg msg) {
		BaseMsg respMsg = onImage(msg.getMediaId(), msg.getPicUrl());
		return responseMsgOrDefault(respMsg, msg);
	}

	@Override
	protected final BaseMsg handleVoiceMsg(VoiceReqMsg msg) {
		BaseMsg respMsg = onVoice(msg.getMediaId(), msg.getFormat());
		return responseMsgOrDefault(respMsg, msg);
	}

	@Override
	protected final BaseMsg handleVideoMsg(VideoReqMsg msg) {
		BaseMsg respMsg = onVideo(msg.getMediaId(), msg.getThumbMediaId());
		return responseMsgOrDefault(respMsg, msg);
	}

	@Override
	protected final BaseMsg handleLocationMsg(LocationReqMsg msg) {
		BaseMsg respMsg = onLocation(msg.getLocationX(), msg.getLocationY(),
				msg.getScale(), msg.getLabel());
		return responseMsgOrDefault(respMsg, msg);
	}

	@Override
	protected BaseMsg handleMenuClickEvent(MenuEvent event) {
		BaseMsg respMsg = onMenuClick(event.getEventKey());
		return responseMsgOrDefault(respMsg, event);
	}

	/**
	 * 如果respMsg不为null，则返回respMsg，否则返回默认消息
	 */
	private BaseMsg responseMsgOrDefault(BaseMsg respMsg, BaseReqMsg reqMsg) {
		if (respMsg != null) {
			return respMsg;
		}

		return handleDefaultMsg(reqMsg);
	}

	/**
	 * 如果respEvent不为null，则返回respEvent，否则返回默认消息
	 */
	private BaseMsg responseMsgOrDefault(BaseMsg respMsg, BaseEvent reqEvent) {
		if (respMsg != null) {
			return respMsg;
		}

		return handleDefaultEvent(reqEvent);
	}
}
