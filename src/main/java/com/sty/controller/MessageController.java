package com.sty.controller;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sty.message.handler.MessageHandler;
import com.sty.message.handler.factory.HandlerFactory;
import com.sty.message.parse.MessageParser;
import com.sty.message.request.RequestMessage;
import com.sty.message.response.ResponseMessage;
import com.sty.utils.ConfigUtil;
import com.sty.utils.StringUtil;
import com.sty.utils.WxMsgEncryptUtil;

@Controller
@RequestMapping("/message")
public class MessageController {
	private static Logger logger = Logger.getLogger(MessageController.class);
	
	@RequestMapping(value = "/weixin", method = RequestMethod.GET)
	@ResponseBody
	public String handleGetMessage(HttpServletRequest request, HttpServletResponse response) {
		logger.info("token验证方法");
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");

		String token = ConfigUtil.token;
		String[] arrStr = { token, timestamp, nonce };
		Arrays.sort(arrStr);
		StringBuffer sb = new StringBuffer();
		for (String str : arrStr) {
			sb.append(str);
		}
		//sha1加密
		String encrptStr = StringUtil.Encrypt(sb.toString());
		logger.info("encrptStr："+encrptStr);
		if (signature.equals(encrptStr)) {
			return echostr;
		}
		return "";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/weixin", method = RequestMethod.POST)
	@ResponseBody
	public String handlePostMessage(HttpServletRequest request, HttpServletResponse response) {
		Map<String,String[]> mapPara = request.getParameterMap();
		logger.info(mapPara);
		String encrypt_type = "";
		//是否加密
		boolean isencrypt = false;
		if(mapPara.get("encrypt_type") != null){
			encrypt_type = mapPara.get("encrypt_type")[0];
		}
		
		try{
			request.setCharacterEncoding("UTF-8");
			InputStream in = request.getInputStream();
			String reqXml = StringUtil.streamToString(in);
			if("aes".equals(encrypt_type)){
				logger.info("进入加密模式");
				logger.info("解密前："+reqXml);
				reqXml = WxMsgEncryptUtil.decryptMsg(mapPara, reqXml);
				logger.info("解密后："+reqXml);
				isencrypt = true;
			}
			
			MessageParser parse = MessageParser.getInstance();
			RequestMessage rqm = parse.parse(reqXml);
			
			MessageHandler msd = HandlerFactory.produceHandler(rqm.getMsgType());
			ResponseMessage rsm = msd.handle(rqm);
			//如果为空恢复空字符串
			if(rsm == null){
				return "";
			}
			
			//处理对象生成微信要求的xml格式
			String xmlRep = StringUtil.objToXml(rsm);
			//判断是否加密
			if(isencrypt){
				String encryptMsg = WxMsgEncryptUtil.encryptResMsg(xmlRep);
				logger.info("加密："+encryptMsg);
				return encryptMsg;
			}
			logger.info("明文："+rsm.toString());
			return xmlRep;
		}catch(Exception e){
			e.printStackTrace();
			logger.error("出错："+e.getMessage());
			return "";
		}
	}
}
