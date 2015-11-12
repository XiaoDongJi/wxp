package com.sty.dao;

import com.sty.entity.AccessToken;

public interface AccessTokenDao {
	/**
	 * 获取accessToken,只有一条
	 * @return
	 */
	AccessToken getAccessToken();
	/**
	 * 更新accessToken
	 * @param accessToken
	 */
	void updateAccessToken(AccessToken accessToken);
	
	void insertAccessToken(AccessToken accessToken);
}
