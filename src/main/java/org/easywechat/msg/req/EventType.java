package org.easywechat.msg.req;

public class EventType {

	/**
	 * 事件类型：subscribe(1、订阅；2、扫描带参数二维码事件，用户未关注时，进行关注后的事件推送)
	 */
	public static final String SUBSCRIBE = "subscribe";

	/**
	 * 事件类型：unsubscribe(取消订阅)
	 */
	public static final String UNSUBSCRIBE = "unsubscribe";

	/**
	 * 事件类型：CLICK(点击菜单拉取消息时的事件推送)
	 */
	public static final String CLICK = "CLICK";

	/**
	 * 事件类型：VIEW(点击菜单跳转链接时的事件推送)
	 */
	public static final String VIEW = "VIEW";

	/**
	 * 事件类型：LOCATION(上报地理位置事件)
	 */
	public static final String LOCATION = "LOCATION";

	/**
	 * 事件类型：SCAN(扫描带参数二维码事件，用户已关注时的事件推送)
	 */
	public static final String SCAN = "SCAN";

}
