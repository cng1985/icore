package com.ada.user.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ada.data.entity.AbstractEntity;

/**
 * 用户验证码
 * 
 * @author aniaojian
 *
 */
@Entity
@Table(name = "user_verification")
public class UserVerification extends AbstractEntity {

	/**
	 * 验证码
	 */
	private String code;

	/**
	 * 用户
	 */
	@ManyToOne
	@JoinColumn(name = "userid")
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
