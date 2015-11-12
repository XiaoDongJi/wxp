package com.sty.message.handler.impl;

import org.apache.log4j.Logger;

import com.sty.message.handler.MessageHandler;
import com.sty.message.request.RequestEventMessage;
import com.sty.message.request.RequestMessage;
import com.sty.message.response.ResponseMessage;
import com.sty.message.response.build.ResponseMessageBuilder;

/**
 * 事件处理类
 * 
 * @author JIXD
 *
 */
public class MessageEventHandler implements MessageHandler {
	private Logger logger = Logger.getLogger(MessageEventHandler.class);
	@Override
	public ResponseMessage handle(RequestMessage rqm) {
		RequestEventMessage reqem = (RequestEventMessage) rqm;
		String event = reqem.getEvent();
		ResponseMessage responseMessage = null;
		switch (event) {
		case "subscribe":
			//直接关注
			if("".equals(reqem.getEventKey()) || null == reqem.getEventKey()){
				responseMessage = ResponseMessageBuilder.buildeTextMessage(rqm, "欢迎关注视听宴。");
			}else{
				//扫码关注，带有参数值
				responseMessage = ResponseMessageBuilder.buildeTextMessage(rqm, "欢迎关注视听宴，扫码关注");
			}
			break;
		case "unsubscribe":
			logger.info("取消关注："+reqem.getFromUserName());
			break;
		case "SCAN":
			//已关注后，继续扫码推送事件
			logger.info("扫码推送："+reqem.getFromUserName());
			break;
		case "LOCATION":
			//上报地理位置事件
			logger.info("上报地理位置事件："+reqem.getFromUserName()+":"+reqem.getLatitude()+"|"+reqem.getLongitude());
			break;
		case "CLICK":
			logger.info("点击菜单拉取消息时的事件推送："+reqem.getFromUserName());
			//点击菜单拉取消息时的事件推送
			break;
		case "VIEW":
			logger.info("点击菜单跳转链接时的事件推送："+reqem.getFromUserName());
			//点击菜单跳转链接时的事件推送
			break;
		default:
			break;
		}
		return responseMessage;
	}

}
