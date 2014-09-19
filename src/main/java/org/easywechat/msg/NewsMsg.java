package org.easywechat.msg;

import java.util.ArrayList;
import java.util.List;

import org.easywechat.util.MessageBuilder;

/**
 * 用于回复的图文消息<br>
 * <br>
 * 
 * 示例代码：
 * <p>
 * <blockquote>
 * 
 * <pre>
 * NewsMsg msg = new NewsMsg();
 * 
 * // 添加只有标题的Article
 * msg.add(&quot;title1&quot;);
 * 
 * // 添加只有标题和链接的Article
 * msg.add(&quot;title2&quot;, &quot;url2&quot;);
 * 
 * // 添加具有标题、链接和图片的Article
 * msg.add(&quot;title&quot;, &quot;picurl&quot;, &quot;url&quot;);
 * 
 * // 添加具有所有参数的Article
 * msg.add(&quot;title&quot;, &quot;description&quot;, &quot;picUrl&quot;, &quot;url&quot;);
 * </pre>
 * 
 * </blockquote>
 * <p>
 * 
 */
public class NewsMsg extends BaseMsg {

	// 微信官方规定每个NewsMsg最多显示10条Article
	private static final int WX_MAX_SIZE = 10;

	// 本条NewsMsg包含的Article条数的上限。默认等于微信规定的条数上限，即10条
	private int maxSize = WX_MAX_SIZE;

	List<Article> articles;

	public NewsMsg() {
		this.articles = new ArrayList<Article>(maxSize);
	}

	/**
	 * 构造图文消息时指定article的最大条数
	 * 
	 * @param maxSize
	 *            article的最大条数
	 */
	public NewsMsg(int maxSize) {
		setMaxSize(maxSize);
		this.articles = new ArrayList<Article>(maxSize);
	}

	/**
	 * 构造图文消息时指定article列表<br>
	 * 注意：构造完成后article列表的变化依然会影响图文消息
	 * 
	 * @param articles
	 *            a list of Article
	 */
	public NewsMsg(List<Article> articles) {
		setArticles(articles);
	}

	/**
	 * 得到Article最大条数
	 */
	public int getMaxSize() {
		return maxSize;
	}

	/**
	 * 设置NewsMsg对象的Article最大条数
	 * 
	 * @param maxSize
	 *            NewsMsg对象的Article最大条数，范围：1~10
	 */
	public void setMaxSize(int maxSize) {
		if (maxSize > WX_MAX_SIZE || maxSize < 1) {
			maxSize = WX_MAX_SIZE;
		}
		this.maxSize = maxSize;
		if (articles != null && articles.size() > maxSize) {
			articles = articles.subList(0, maxSize);
		}
	}

	public List<Article> getArticles() {
		return articles;
	}

	/**
	 * 设置图文消息的Articel列表
	 * 
	 * @param articles
	 *            a list of Article
	 */
	public NewsMsg setArticles(List<Article> articles) {
		if (articles.size() > maxSize) {
			this.articles = articles.subList(0, maxSize);
		} else {
			this.articles = articles;
		}
		return this;
	}

	/**
	 * 为NewsMsg添加一条只含有标题的Article
	 * 
	 * @param title
	 *            Article的标题
	 */
	public NewsMsg add(String title) {
		return add(title, null, null, null);
	}

	/**
	 * 为NewsMsg添加一条只含有标题和链接的Article
	 * 
	 * @param title
	 *            Article的标题
	 * @param url
	 *            Article的链接
	 */
	public NewsMsg add(String title, String url) {
		return add(title, null, null, url);
	}

	/**
	 * 为NewsMsg添加一条含有标题、链接和图片链接的Article
	 * 
	 * @param title
	 *            Article的标题
	 * @param picUrl
	 *            Article中图片的来源地址
	 * @param url
	 *            Article的链接
	 */
	public NewsMsg add(String title, String picUrl, String url) {
		return add(new Article(title, null, picUrl, url));
	}

	/**
	 * 为NewsMsg添加一条Article
	 * 
	 * @param title
	 *            Article的标题
	 * @param description
	 *            Article的描述
	 * @param picUrl
	 *            Article中图片的来源地址
	 * @param url
	 *            Article的链接
	 */
	public NewsMsg add(String title, String description, String picUrl,
			String url) {
		return add(new Article(title, description, picUrl, url));
	}

	/**
	 * 为图文消息添加一条Article
	 * 
	 * @param article
	 */
	public NewsMsg add(Article article) {
		if (this.articles.size() < maxSize) {
			this.articles.add(article);
		} else {
			// 如果Article条数已满，则不再添加
		}
		return this;
	}

	@Override
	/**
	 * {@inheritDoc}
	 */
	public String toXml() {
		MessageBuilder mb = new MessageBuilder(super.toXml());
		mb.addData("MsgType", RespType.NEWS);
		mb.addTag("ArticleCount", String.valueOf(articles.size()));
		mb.append("<Articles>\n");
		for (Article article : articles) {
			mb.append(article.toXml());
		}
		mb.append("</Articles>\n");
		mb.surroundWith("xml");
		return mb.toString();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("NewsMsg [articles=\n");
		for (int i = 0; i < articles.size(); i++) {
			sb.append("  Article ").append(i).append(": ")
					.append(articles.get(i)).append("\n");
		}
		sb.append("]");
		return sb.toString();
	}

}
