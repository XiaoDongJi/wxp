package com.sty.utils;

import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.sty.dao.AccessTokenDao;
import com.sty.entity.AccessToken;

/**
 * accessToken获取工具类，处理刷新时间问题
 * @author JIXD
 *
 */
public class AccessTokenUtil {
	private static Logger logger = Logger.getLogger(AccessTokenUtil.class);
	
	private static AccessTokenDao tokenDao = (AccessTokenDao) SpringUtil.getBean("accessTokenDaoImpl");
	
	/**
	 * 获取token
	 * @return
	 */
	public static String getAccessToken(){
		AccessToken accesstoken = tokenDao.getAccessToken();
		DateTimeUtil.getCurrentDataTime();
		String token = "";
		if(accesstoken == null){
			token = insertAccessToken();
		}else{
			Date curr_date = new Date();
			Date expires_date = DateTimeUtil.getDateFromString(accesstoken.getExpires_time());
			// 时间是否在参数date之后
			if (curr_date.after(expires_date)) {
				token = refreshAccessToken();
			}else{
				token = accesstoken.getAccess_token();
			}
		}
		logger.info("token:"+token);
		
		return token;
	}
	
	/**
	 * 更新token
	 */
	private static String refreshAccessToken(){
		AccessToken accessToken = wxQuery();
		tokenDao.updateAccessToken(accessToken);
		return accessToken.getAccess_token();
	}
	
	/**
	 * 插入新纪录
	 */
	private static String insertAccessToken(){
		AccessToken accessToken = wxQuery();
		tokenDao.insertAccessToken(accessToken);
		return accessToken.getAccess_token();
	}
	/**
	 * 请求微信最新token
	 * @return
	 */
	private static AccessToken wxQuery(){
		AccessToken accessToken = new AccessToken();
		String url = ConfigUtil.Url_AccessToken+"&appid="+ConfigUtil.AppId+"&secret"+ConfigUtil.AppSecret;
		String accessTokenStr = HttpClientUtil.get(url);
		JSONObject tokenjson = new JSONObject(accessTokenStr);
		accessToken.setId(ConfigUtil.OriginId);
		accessToken.setAccess_token(tokenjson.getString("access_token"));
		accessToken.setExpires_in(tokenjson.getInt("expires_in"));
		//设置换算过期时间
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		//减200秒，防止过期
		calendar.add(Calendar.SECOND, tokenjson.getInt("expires_in")-200);
		
		accessToken.setExpires_time(DateTimeUtil.formatDate(calendar.getTime()));
		return accessToken;
	}
}
