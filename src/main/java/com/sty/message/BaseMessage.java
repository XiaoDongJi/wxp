package com.sty.message;
/**
 * 消息类父类
 * @author JIXD
 *
 */
public abstract class BaseMessage {
	//接收者
	private String ToUserName;
	//发送者
	private String FromUserName;
	//时间戳
	private String CreateTime;
	//消息类型
	private String MsgType;
	
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public String getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	
	
}
