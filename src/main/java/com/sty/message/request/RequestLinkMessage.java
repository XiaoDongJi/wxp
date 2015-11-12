package com.sty.message.request;


public class RequestLinkMessage extends RequestMessage{
	//消息标题 
	private String Title;
	//消息描述 
	private String Description;
	//消息链接 
	private String Url;
	
	
	public RequestLinkMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RequestLinkMessage(String title, String description, String url) {
		super();
		Title = title;
		Description = description;
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
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	
	

}
