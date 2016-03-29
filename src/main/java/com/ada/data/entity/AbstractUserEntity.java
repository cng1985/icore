package com.ada.data.entity;

import java.io.Serializable;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.ada.user.entity.UserInfo;


@MappedSuperclass
public abstract class AbstractUserEntity extends AbstractEntity implements Serializable{



	/**
	 * 用户
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	private UserInfo user;

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	
}
