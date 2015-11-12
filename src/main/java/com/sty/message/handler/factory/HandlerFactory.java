package com.sty.message.handler.factory;

import com.sty.message.handler.MessageHandler;

/**
 * 简单工厂模式
 * 消息处理类的工厂
 * @author JIXD
 *
 */
public class HandlerFactory {
	
	public static MessageHandler produceHandler(String handlerType){
		try {
			if(handlerType !=null && handlerType.length()>1){
				handlerType = handlerType.substring(0, 1).toUpperCase() + handlerType.substring(1, handlerType.length());
			}
			MessageHandler msh = (MessageHandler) Class.forName("com.sty.message.handler.impl.Message"+handlerType+"Handler").newInstance();
			return msh;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		String str = "text";
		String c = str.substring(0, 1).toUpperCase() + str.substring(1, str.length());
		
		
	}
}
