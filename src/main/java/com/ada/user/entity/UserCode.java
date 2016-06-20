package com.ada.user.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ada.data.entity.AbstractEntity;

/**
 * 用户状态吗登录相当于匿名登录
 */
@Entity
@Table(name = "user_code")
public class UserCode extends AbstractEntity {

	private String code;

	/**
	 * 和用户绑定
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid")
	private UserInfo user;

	/**
	 * 通过该code登录的次数
	 */
	private Integer loginSize;

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

	public Integer getLoginSize() {
		return loginSize;
	}

	public void setLoginSize(Integer loginSize) {
		this.loginSize = loginSize;
	}

	
	
}
