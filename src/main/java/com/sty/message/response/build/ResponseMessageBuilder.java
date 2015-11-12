package com.sty.message.response.build;

import com.sty.message.request.RequestMessage;
import com.sty.message.response.ResponseImageMessage;
import com.sty.message.response.ResponseMessage;
import com.sty.message.response.ResponseTextMessage;
import com.sty.utils.DateTimeUtil;
import com.sty.utils.StringUtil;

/**
 * 创建响应消息的工具类
 * @author JIXD
 *
 */
public class ResponseMessageBuilder {
	
	/**
	 * 创建文字响应消息
	 * @param requestMessage
	 * @param content
	 * @return
	 */
	public static ResponseMessage buildeTextMessage(RequestMessage requestMessage,String content){
		ResponseTextMessage restm = new ResponseTextMessage();
		restm.setFromUserName(StringUtil.addCDATA(requestMessage.getToUserName()));
		restm.setToUserName(StringUtil.addCDATA(requestMessage.getFromUserName()));
		restm.setContent(StringUtil.addCDATA(content));
		restm.setMsgType(StringUtil.addCDATA("text"));
		restm.setCreateTime(DateTimeUtil.getCreateTime());
		return restm;
	}
	
	/**
	 * 创建图片响应消息
	 * @param requestMessage
	 * @param content
	 * @return
	 */
	public static ResponseMessage buildeImageMessage(RequestMessage requestMessage,String media_id){
		ResponseImageMessage resim = new ResponseImageMessage();
			
		resim.setFromUserName(requestMessage.getToUserName());
		resim.setToUserName(requestMessage.getFromUserName());
		
		return resim;
	}
}
