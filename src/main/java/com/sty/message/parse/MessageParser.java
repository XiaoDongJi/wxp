package com.sty.message.parse;

import java.util.Map;

import com.sty.message.request.RequestEventMessage;
import com.sty.message.request.RequestImageMessage;
import com.sty.message.request.RequestLinkMessage;
import com.sty.message.request.RequestLocationMessage;
import com.sty.message.request.RequestMessage;
import com.sty.message.request.RequestTextMessage;
import com.sty.message.request.RequestVideoMessage;
import com.sty.message.request.RequestVoiceMessage;
import com.sty.utils.StringUtil;

/**
 * 解析message生成message对象
 * 
 * @author JIXD
 *
 */
public class MessageParser {
	private static MessageParser parseMsg = null;

	private MessageParser() {
	}

	// 双重检查锁定
	public static MessageParser getInstance() {
		if (parseMsg == null) {
			synchronized (MessageParser.class) {
				if (parseMsg == null) {
					parseMsg = new MessageParser();
				}
			}
		}
		return parseMsg;
	}

	/**
	 * 解析xml数据为具体对象
	 * @param reqXml
	 * @return
	 */
	public RequestMessage parse(String reqXml) {
		Map<String, String> reqMap = StringUtil.xmlToMap(reqXml);
		String msgType = reqMap.get("MsgType");
		RequestMessage rm = null;
		switch (msgType) {
		case "text":
			rm = new RequestTextMessage(reqMap.get("Content"));
			rm.setMsgType("text");
			break;
		case "image":
			rm = new RequestImageMessage(reqMap.get("PicUrl"), reqMap.get("MediaId"));
			rm.setMsgType("image");
			break;
		case "voice": {
			rm = new RequestVoiceMessage(reqMap.get("MediaId"), reqMap.get("Format"));
			rm.setMsgType("voice");
			break;
		}
		case "video": {
			rm = new RequestVideoMessage(reqMap.get("MediaId"), reqMap.get("ThumbMediaId"));
			rm.setMsgType("video");
			break;
		}
		case "shortvideo": {
			rm = new RequestVideoMessage(reqMap.get("MediaId"), reqMap.get("ThumbMediaId"));
			rm.setMsgType("shortvideo");
			break;
		}
		case "location": {
			rm = new RequestLocationMessage(reqMap.get("Location_X"), reqMap.get("Location_Y"), reqMap.get("Scale"),
					reqMap.get("Label"));
			rm.setMsgType("location");
			break;
		}
		case "link": {
			rm = new RequestLinkMessage(reqMap.get("Title"), reqMap.get("Description"), reqMap.get("Url"));
			rm.setMsgType("link");
			break;
		}
		case "event": {
			//包含多个事件类型，统一放到一个对象中
			rm = new RequestEventMessage(reqMap.get("Event"), reqMap.get("EventKey"), reqMap.get("Ticket"),
					reqMap.get("Latitude"), reqMap.get("Longitude"), reqMap.get("Precision"));
			rm.setMsgType("event");
		}
		default:
			break;
		}
		rm.setToUserName(reqMap.get("ToUserName"));
		rm.setFromUserName(reqMap.get("FromUserName"));
		rm.setCreateTime(reqMap.get("CreateTime"));
		rm.setMsgId(reqMap.get("MsgId"));// 如果未事件类型则没有
		return rm;
	}

}
