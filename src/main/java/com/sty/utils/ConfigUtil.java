package com.sty.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConfigUtil {
	private static Logger logger = Logger.getLogger(ConfigUtil.class);
	private static String propertiesPath = "";
	public static String AppId = "";
	public static String AppSecret = "";
	public static String PrevEncodingAesKey = "";
	public static String CurrEncodingAesKey = "";
	public static String token = "";
	public static String Url_AccessToken = "";
	public static String OriginId = "";
	
	static {
		// WEB-INF/classes路径
		String path = ConfigUtil.class.getClassLoader().getResource("//").getPath();
		propertiesPath = path + "config.properties";
		// 如果路径中有空格获取出来会是%20，需要替换
		propertiesPath = propertiesPath.replaceAll("%20", " ");
		refresh();
	}
	
	//加载配置文件数据
	private static void refresh() {
		Properties properties = new Properties();
		InputStream is = null;
		try {
			is = new FileInputStream(propertiesPath);
			properties.load(is);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(properties.isEmpty()){
			logger.error("配置文件异常");
			return;
		}
		
		AppId = properties.getProperty("AppId");
		AppSecret = properties.getProperty("AppSecret");
		CurrEncodingAesKey = properties.getProperty("CurrEncodingAesKey");
		PrevEncodingAesKey = properties.getProperty("PrevEncodingAesKey");
		token = properties.getProperty("token");
		Url_AccessToken = properties.getProperty("Url_AccessToken");
		OriginId = properties.getProperty("OriginId");
		
		try {
			if (is != null) {
			is.close();
		 }
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
