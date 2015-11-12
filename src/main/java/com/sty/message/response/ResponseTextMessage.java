package com.sty.message.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 文字消息
 * @author JIXD
 *
 */
@XStreamAlias("xml")
public class ResponseTextMessage extends ResponseMessage{
	
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("<xml>\n");
		sb.append("<ToUserName><![CDATA["+this.getToUserName()+"]]></ToUserName>\n");
		sb.append("<FromUserName><![CDATA["+this.getFromUserName()+"]]></FromUserName>\n");
		sb.append("<CreateTime>"+this.getCreateTime()+"</CreateTime>\n");
		sb.append("<MsgType><![CDATA[text]]></MsgType>\n");
		sb.append("<Content><![CDATA["+Content+"]]></Content>\n");
		sb.append("</xml>");
		return sb.toString();
	}
	
}
