package com.sty.message.request;
/**
 * 语音消息
 * @author JIXD
 *
 */
public class RequestVoiceMessage extends RequestMessage{
	//语音消息媒体id，可以调用多媒体文件下载接口拉取数据
	private String MediaId;
	//语音格式，如amr，speex等 
	private String Format;
	
	
	public RequestVoiceMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RequestVoiceMessage(String mediaId, String format) {
		super();
		MediaId = mediaId;
		Format = format;
	}
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getFormat() {
		return Format;
	}
	public void setFormat(String format) {
		Format = format;
	}
	
	
}
