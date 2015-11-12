package com.sty.message.response;

import com.sty.message.response.media.Articles;
import com.thoughtworks.xstream.annotations.XStreamAlias;
/**
 * 图文消息
 * @author JIXD
 *
 */
@XStreamAlias("xml")
public class ResponseNewsMessage extends ResponseMessage{
	
	private String ArticleCount;
	@XStreamAlias("Articles")
	private Articles articles;
	
	public String getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(String articleCount) {
		ArticleCount = articleCount;
	}
	public Articles getArticles() {
		return articles;
	}
	public void setArticles(Articles articles) {
		this.articles = articles;
	}
	
}
