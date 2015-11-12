package com.sty.message.handler.impl;

import com.sty.message.handler.MessageHandler;
import com.sty.message.request.RequestMessage;
import com.sty.message.request.RequestTextMessage;
import com.sty.message.response.ResponseMessage;
import com.sty.message.response.ResponseTextMessage;
import com.sty.utils.DateTimeUtil;

public class MessageTextHandler implements MessageHandler{

	@Override
	public ResponseMessage handle(RequestMessage rqm) {
		RequestTextMessage reqtm = (RequestTextMessage)rqm;
		ResponseTextMessage restm = new ResponseTextMessage();
		
		restm.setToUserName(reqtm.getFromUserName());
		restm.setFromUserName(reqtm.getToUserName());
		restm.setContent("you are pig");
		restm.setMsgType("text");
		restm.setCreateTime(DateTimeUtil.getCreateTime());
		return restm;
	}
}
