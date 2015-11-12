package com.sty.message.response.media;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
/**
 * 图文消息中的文章节点
 * @author JIXD
 *
 */
public class Articles {
	
	@XStreamAlias("item")
	private List<Item> list;

	public List<Item> getList() {
		return list;
	}

	public void setList(List<Item> list) {
		this.list = list;
	}
	
}
/**
 * 具体文章
 * @author JIXD
 *
 */
class Item{
	private String Title;
	private String Description;
	private String PicUrl;
	private String Url;
	
	public Item() {
		super();
	}
	
	public Item(String title, String description, String picUrl, String url) {
		super();
		Title = title;
		Description = description;
		PicUrl = picUrl;
		Url = url;
	}

	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getPicUrl() {
		return PicUrl;
	}
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	
}
