package com.sty.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;

/**
 * 发送请求http请求类
 * @author JIXD
 *
 */
public class HttpClientUtil {
	private Logger logger = Logger.getLogger(HttpClientUtil.class);
	/**
	 * get请求
	 * @param url 请求url
	 * @return
	 */
	public static String get(String url){
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		StringBuffer sb = new StringBuffer();
		BufferedReader br = null;
		CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httpGet);
			if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
				HttpEntity entity = response.getEntity();
				br = new BufferedReader(new InputStreamReader(entity.getContent()));
				String line = "";
				while((line = br.readLine()) != null){
					sb.append(line);
				}
			}
			response.close();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try{
				if(br!=null){
					br.close();
				}
				if(response!=null){
					response.close();
				}
			}catch(Exception e){
				
			}
			
		}
		return sb.toString();
	}
	
	/**
	 * post请求
	 * @param url
	 * @param data
	 * @return
	 */
	public static String post(String url,String data){
		 CloseableHttpClient httpclient = HttpClients.createDefault();
		 HttpPost httppost = new HttpPost(url);
		 RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(15000).setConnectTimeout(15000).build();
		 httppost.setConfig(requestConfig);
		 StringEntity entity = new StringEntity(data, "UTF-8");
		 entity.setContentType("application/x-www-form-urlencoded");
		 httppost.setEntity(entity);
		 StringBuffer sb = new StringBuffer();
		 BufferedReader br = null;
		 CloseableHttpResponse response = null;
		 try {
			 response = httpclient.execute(httppost);
			 if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
				 br = new BufferedReader(new InputStreamReader(entity.getContent()));
					String line = "";
					while((line = br.readLine()) != null){
						sb.append(line);
					}
			 }
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try{
				if(br!=null){
					br.close();
				}
				if(response!=null){
					response.close();
				}
			}catch(Exception e){
				
			}
		}
		return sb.toString();
	}
	
}
