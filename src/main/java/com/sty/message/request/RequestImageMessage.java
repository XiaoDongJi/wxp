package com.sty.message.request;

public class RequestImageMessage extends RequestMessage {
	//图片链接 
	private String PicUrl;
	//图片消息媒体id，可以调用多媒体文件下载接口拉取数据
	private String MediaId;
	
	
	public RequestImageMessage() {
		super();
	}
	public RequestImageMessage(String picUrl, String mediaId) {
		super();
		PicUrl = picUrl;
		MediaId = mediaId;
	}
	public String getPicUrl() {
		return PicUrl;
	}
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	
}
