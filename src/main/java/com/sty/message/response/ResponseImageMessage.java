package com.sty.message.response;

import com.sty.message.response.media.Image;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class ResponseImageMessage extends ResponseMessage{

	private String MsgType;
	
	@XStreamAlias("Image")
	private Image image;
	
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	
	
	
}
