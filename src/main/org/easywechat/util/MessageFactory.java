package org.easywechat.util;

import org.easywechat.msg.ImageMsg;
import org.easywechat.msg.MusicMsg;
import org.easywechat.msg.NewsMsg;
import org.easywechat.msg.TextMsg;
import org.easywechat.msg.VideoMsg;
import org.easywechat.msg.VoiceMsg;

/**
 * 构建响应消息的工厂类
 */
public class MessageFactory {

	/**
	 * 返回内容为空的文本消息
	 */
	public static TextMsg createTextMsg() {
		return new TextMsg();
	}

	/**
	 * 返回指定内容的文本消息
	 * 
	 * @param content
	 *            回复的消息内容
	 */
	public static TextMsg createTextMsg(String content) {
		return new TextMsg(content);
	}

	/**
	 * 返回图片消息
	 * 
	 * @param mediaId
	 *            通过上传多媒体文件，得到的id
	 */
	public static ImageMsg createImageMsg(String mediaId) {
		return new ImageMsg(mediaId);
	}

	/**
	 * 返回语音消息
	 * 
	 * @param mediaId
	 *            通过上传多媒体文件，得到的id
	 */
	public static VoiceMsg createVoiceMsg(String mediaId) {
		return new VoiceMsg(mediaId);
	}

	/**
	 * 返回视频消息
	 * 
	 * @param mediaId
	 *            通过上传多媒体文件，得到的id
	 * @param title
	 *            视频消息的标题。如不需要可设为null
	 * @param description
	 *            视频消息的描述。如不需要可设为null
	 */
	public static VideoMsg createVideoMsg(String mediaId, String title,
			String description) {
		return new VideoMsg(mediaId, title, description);
	}

	/**
	 * 返回音乐消息
	 * 
	 * @param thumbMediaId
	 *            缩略图的媒体id，通过上传多媒体文件，得到的id
	 * @param title
	 *            音乐标题。如不需要可设为null
	 * @param description
	 *            音乐描述。如不需要可设为null
	 * @param musicUrl
	 *            音乐链接。如不需要可设为null
	 * @param hqMusicUrl
	 *            高质量音乐链接，WIFI环境优先使用该链接播放音乐。如不需要可设为null
	 */
	public static MusicMsg createMusicMsg(String thumbMediaId, String title,
			String description, String musicUrl, String hqMusicUrl) {
		return new MusicMsg(thumbMediaId, title, description, musicUrl,
				hqMusicUrl);
	}

	/**
	 * 返回内容为空的图文消息
	 */
	public static NewsMsg createNewsMsg() {
		return new NewsMsg();
	}

	/**
	 * 返回具有一条Article的图文消息
	 * 
	 * @param title
	 *            图文消息标题。可为null
	 * @param description
	 *            图文消息描述。可为null
	 * @param picUrl
	 *            图片链接。可为null
	 * @param url
	 *            点击图文消息跳转链接。可为null
	 */
	public static NewsMsg createNewsMsg(String title, String description,
			String picUrl, String url) {
		return new NewsMsg().add(title, description, picUrl, url);
	}

}
