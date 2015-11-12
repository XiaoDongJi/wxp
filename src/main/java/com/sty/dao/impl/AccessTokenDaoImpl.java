package com.sty.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.sty.dao.AccessTokenDao;
import com.sty.entity.AccessToken;
import com.sty.utils.ConfigUtil;

@Repository
public class AccessTokenDaoImpl implements AccessTokenDao {

	@Autowired
	private MongoTemplate mongoTemplate;

	public AccessToken getAccessToken() {
		return mongoTemplate.findOne(new Query(Criteria.where("_id").is(ConfigUtil.OriginId)), AccessToken.class, "token");
	}

	public void updateAccessToken(AccessToken accessToken) {
		Query query = new Query(Criteria.where("_id").is(ConfigUtil.OriginId));
		Update update = new Update().set("access_token", accessToken.getAccess_token())
				.set("expires_in", accessToken.getExpires_in()).set("expires_time", accessToken.getExpires_time());
		mongoTemplate.updateFirst(query, update, "token");
	}

	public void insertAccessToken(AccessToken accessToken) {
		mongoTemplate.insert(accessToken, "token");
	}

}
