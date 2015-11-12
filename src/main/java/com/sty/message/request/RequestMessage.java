package com.sty.message.request;

import com.sty.message.BaseMessage;
/**
 * 请求消息
 * @author JIXD
 *
 */
public class RequestMessage extends BaseMessage{
	//消息id
	private String MsgId;

	public String getMsgId() {
		return MsgId;
	}

	public void setMsgId(String msgId) {
		MsgId = msgId;
	}
	
	
}
