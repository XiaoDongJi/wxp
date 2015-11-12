package com.sty.message.request;
/**
 * 文字请求消息
 * @author JIXD
 *
 */
public class RequestTextMessage extends RequestMessage{
	//请求内容
	private String Content;

	
	
	public RequestTextMessage() {
		super();
	}

	public RequestTextMessage(String content) {
		super();
		Content = content;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
	
}
