package com.ada.user.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.ada.data.entity.AbstractEntity;

/**
 * 用户oauth登陆信息
 * 
 * @author 73552
 *
 */
@Entity
@Table(name = "user_oauth_token")
public class UserOauthToken extends AbstractEntity {

	private String access_token;

	private String refresh_token;
	private String token_type;

	private Long uid;

	private Long expires_in;

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public String getToken_type() {
		return token_type;
	}

	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Long getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(Long expires_in) {
		this.expires_in = expires_in;
	}

}
