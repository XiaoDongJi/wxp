package com.sty.entity;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 凭证accesstoken,全部存入mongodb数据库，自动生成id
 * @author JIXD
 *
 */

@Document
public class AccessToken {
	
	private String id;
	private String access_token;
	private int expires_in;
	private String expires_time;
	
	
	public AccessToken() {
		super();
	}
	public AccessToken(String access_token, int expires_in, String expires_time) {
		super();
		this.access_token = access_token;
		this.expires_in = expires_in;
		this.expires_time = expires_time;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public int getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}
	public String getExpires_time() {
		return expires_time;
	}
	public void setExpires_time(String expires_time) {
		this.expires_time = expires_time;
	}
	@Override
	public String toString() {
		return "AccessToken [id=" + id + ", access_token=" + access_token + ", expires_in=" + expires_in
				+ ", expires_time=" + expires_time + "]";
	}
	
	
}
