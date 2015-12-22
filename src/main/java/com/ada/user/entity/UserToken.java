package com.ada.user.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ada.data.entity.AbstractEntity;

/**
 * 用户令牌
 */
@Entity
@Table(name = "user_token")
public class UserToken extends AbstractEntity {

	/**
	 * 令牌
	 */
	private String code;

	/**
	 * 用户
	 */
	@ManyToOne
	@JoinColumn(name="userid")
	private UserInfo user;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}
	

}
