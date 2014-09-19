package org.easywechat.msg;

import org.easywechat.util.MessageBuilder;

/**
 * 用于回复的文本消息<br>
 * <br>
 * 
 * 示例代码：
 * <p>
 * <blockquote>
 * 
 * <pre>
 * // 通过构造方法传入消息文本（之后可以再添加消息内容）
 * TextMsg msg = new TextMsg(&quot;hey:&quot;);
 * 
 * // addln方法可以添加一行内容（联想println）
 * // 不同的是，支持链式编程
 * msg.addln().addln(&quot;some text&quot;).addln(&quot;some other text&quot;);
 * 
 * // 添加超链接
 * msg.addLink(&quot;点击访问网页&quot;, &quot;http://www.example.com&quot;);
 * 
 * // 输出消息内容
 * System.out.println(msg.getContent());
 * 
 * // 输出结果如下：
 * // hey:
 * // some text
 * // some other text
 * // &lt;a href=&quot;http://www.example.com&quot;&gt;点击访问网页&lt;/a&gt;
 * 
 * </pre>
 * 
 * </blockquote>
 * <p>
 */
public final class TextMsg extends BaseMsg {

	// 回复的消息内容
	private StringBuilder contentBuilder;

	public String getContent() {
		return contentBuilder.toString();
	}

	public void setContent(String content) {
		contentBuilder = new StringBuilder(content);
	}

	public TextMsg() {
		contentBuilder = new StringBuilder();
	}

	public TextMsg(String content) {
		setContent(content);
	}

	/**
	 * 添加消息内容
	 */
	public TextMsg add(String text) {
		contentBuilder.append(text);
		return this;
	}

	/**
	 * 添加换行符
	 */
	public TextMsg addln() {
		return add("\n");
	}

	/**
	 * 先添加消息内容text，再添加换行符
	 */
	public TextMsg addln(String text) {
		contentBuilder.append(text);
		return addln();
	}

	/**
	 * 添加文本为text,链接为url的超链接. 形如
	 * <p>
	 * &lt;a href=&quot;url&quot;&gt;text&lt;/a&gt;
	 * </p>
	 */
	public TextMsg addLink(String text, String url) {
		contentBuilder.append("<a href=\"").append(url).append("\">")
				.append(text).append("</a>");
		return this;
	}

	@Override
	public String toXml() {
		MessageBuilder mb = new MessageBuilder(super.toXml());
		mb.addData("Content", contentBuilder.toString());
		mb.addData("MsgType", RespType.TEXT);
		mb.surroundWith("xml");
		return mb.toString();
	}

	@Override
	public String toString() {
		return "TextMsg [content=" + getContent() + "]";
	}

}
