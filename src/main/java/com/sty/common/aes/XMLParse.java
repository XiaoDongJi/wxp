/**
 * 对公众平台发送给公众账号的消息加解密示例代码.
 * 
 * @copyright Copyright (c) 1998-2014 Tencent Inc.
 */

// ------------------------------------------------------------------------

package com.sty.common.aes;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 * XMLParse class
 *
 * 提供提取消息格式中的密文及生成回复消息格式的接口.
 */
class XMLParse {

	/**
	 * 提取出xml数据包中的加密消息
	 * @param xmltext 待提取的xml字符串
	 * @return 提取出的加密消息字符串
	 * @throws AesException 
	 */
	public static Object[] extract(String xmltext) throws AesException     {
		Object[] result = new Object[3];
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			StringReader sr = new StringReader(xmltext);
			InputSource is = new InputSource(sr);
			Document document = db.parse(is);

			Element root = document.getDocumentElement();
			NodeList nodelist1 = root.getElementsByTagName("Encrypt");
			NodeList nodelist2 = root.getElementsByTagName("ToUserName");
			result[0] = 0;
			result[1] = nodelist1.item(0).getTextContent();
			result[2] = nodelist2.item(0).getTextContent();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AesException(AesException.ParseXmlError);
		}
	}

	/**
	 * 生成xml消息
	 * @param encrypt 加密后的消息密文
	 * @param signature 安全签名
	 * @param timestamp 时间戳
	 * @param nonce 随机字符串
	 * @return 生成的xml字符串
	 */
	public static String generate(String encrypt, String signature, String timestamp, String nonce) {

		String format = "<xml>\n" + "<Encrypt><![CDATA[%1$s]]></Encrypt>\n"
				+ "<MsgSignature><![CDATA[%2$s]]></MsgSignature>\n"
				+ "<TimeStamp>%3$s</TimeStamp>\n" + "<Nonce><![CDATA[%4$s]]></Nonce>\n" + "</xml>";
		return String.format(format, encrypt, signature, timestamp, nonce);

	}
	
	public static void main(String[] args) {
		String xml = "<xml>    <ToUserName><![CDATA[gh_d2f8b4ecd044]]></ToUserName>    <Encrypt><![CDATA[ItP1EiCPh3TIgwHQEmipZXwiVF3AifG9HtHO7b+OGBHY8eCWxB8RjuL48iOiVFVi+g+lOOtSDlmQjA0vWP8xsf866DL1Ef6AYlz15yICrmV3KtMvRDnrmhGO7omTgcbK08nHgMAFf4HsjwHrVlvgOdd4JS4KkFvUbGxzHx72I4/8Yx/ObZ8XSkaODbHp3laACjQHlTGKRCjkSJ+68EIop3a+qO+DXsMzbSVW/BGHZVyoI2hGSEo3l/+DfjCPZ5kFiM4jxsAoh8yinHQzSkY04WjGoy7ycbC2fbzfl+p1p81If5pyU+v7z744/iMxpL3byEtJnu591OVrth21XLFWK6bLREaTvBPp3vtwuWHWLRC7ECNK8F5fpFthuNxeebiAyg9zrNAhyDyefUlRNW/q0O9lbnx1bgl7MMKOzdhGlRk=]]></Encrypt></xml>";
		try {
			Object[] obj = extract(xml);
		} catch (AesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
