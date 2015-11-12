package com.sty.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.sty.message.response.ResponseImageMessage;
import com.sty.message.response.ResponseMessage;
import com.sty.message.response.media.Image;
import com.thoughtworks.xstream.XStream;


public class StringUtil {

	/**
	 * 对字符串进行sha1加密操作
	 * @param strSrc
	 * @return
	 */
	public static String Encrypt(String strSrc) {
		MessageDigest md = null;
		String strDes = null;
		byte[] bt = strSrc.getBytes();
		try {
			md = MessageDigest.getInstance("SHA-1");
			md.update(bt);
			strDes = StringUtil.bytes2Hex(md.digest()); // to HexString
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Invalid algorithm.");
			return null;
		}
		return strDes;

	}

	public static String bytes2Hex(byte[] bts) {
		String des = "";
		String tmp = null;
		for (int i = 0; i < bts.length; i++) {
			tmp = (Integer.toHexString(bts[i] & 0xFF));
			if (tmp.length() == 1) {
				des += "0";

			}
			des += tmp;
		}
		return des;
	}
	
	/**
	 * xml转换成map
	 * @return 
	 */
	public static Map<String,String> xmlToMap(String xmlstr){
		Document document;
		Map<String,String> map = new HashMap<String,String>();
		try {
			document = DocumentHelper.parseText(xmlstr);
			Element root=document.getRootElement();
		    for(Iterator<Element> iterator = root.elementIterator();iterator.hasNext();){
		    	Element node = iterator.next();
		    	map.put(node.getName(), node.getTextTrim());
		    }
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 输入流转换成字符串
	 * @param in
	 * @return
	 */
	public static String streamToString(InputStream in){
		BufferedReader br = null;
		StringBuffer sb = new StringBuffer();
		try{
			if(in != null){
				br = new BufferedReader(new InputStreamReader(in));
				String temp;
				while((temp = br.readLine())!=null){
					sb.append(temp);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(in!=null){
					in.close();
				}
				if(br!=null){
					br.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
	/**
	 * 对象转换为xml
	 * @param resp
	 * @return
	 */
	public static String objToXml(ResponseMessage resp){
		XStream xStream = new XStream();
		xStream.setMode(XStream.NO_REFERENCES);
		//xStream.processAnnotations(new Class[]{ResponseImageMessage.class,Image.class});
		//开启自动侦测，会缓存注解，对性能会有影响
		xStream.autodetectAnnotations(true);  
		String xml = xStream.toXML(resp); 
		return xml;
	}
	/**
	 * 添加<![CDATA[]]
	 * @param content
	 * @return
	 */
	public static String addCDATA(String content){
		return "<![CDATA["+content+"]]";
	}
	
	/**
	 * 判断字符串是否为空
	 *
	 * @param s
	 * @return 是否为空
	 */
	public static boolean isNullStr(String s) {
		if (s == null || s.trim().length() <= 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 将Object对象转变为String类型对象，对于null值返回空字符串.
	 * 
	 * @param inObj
	 *            待处理的对象.
	 */
	public static String killNull(Object inObj) {
		if (inObj == null) {
			return "";
		}
		return inObj.toString().trim();
	}

	/**
	 * 只保留 数字 英文 中文 ？
	 * 
	 * @param s
	 * @return
	 */
	public static String killSymbol(String s) {
		String str = s;
		// String
		// str="123456789azAZ啊 `~@!#$%^&*()-=_+[]{%……&*（）——+-=【】{}；：‘”，《。》、？、|～！＠＃＄％＾＆＊（）＿＋－＝［］｛｝；：＇＂，＜．＞／？＼｜～！＠＃￥％……＆×（）－};:,<.>/?·~！@#￥＝——＋【】｛｝；：‘”，《。》、？";
		str = str.replaceAll("[^a-zA-Z0-9\u4E00-\u9FA5?？]", "");
		return str;
	}

	/**
	 * 返回32位唯一编码
	 * 
	 */
	public static String getUUID() {
		return java.util.UUID.randomUUID().toString().replaceAll("-", "");
	}

	/**
	 * 返回订单编码
	 * 
	 */
	public static String getOrderId() {
		String id = "";
		// SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSSS");
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
		Random r = new Random();
		id = sdf.format(new Date()) + r.nextInt(9) + r.nextInt(9)
				+ r.nextInt(9) + r.nextInt(9);
		return id;
	}

	/**
	 * 将指定字符串转成指定格式
	 * 
	 * @param str
	 * @return
	 */
	public static String convertStr(String str, String format) {
		try {
			return new String(str.getBytes(), format);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

	public static void main(String[] args) {
		ResponseImageMessage respim = new ResponseImageMessage();
		Image image = new Image();
		image.setMediaId("009999");
		respim.setImage(image);
		respim.setCreateTime("0099");
		respim.setFromUserName("nlllsdfsdf");
		respim.setToUserName("0099ikk");
		respim.setMsgType("Image");
		
		String xml = objToXml(respim);
		System.out.println(xml);
	}
}
