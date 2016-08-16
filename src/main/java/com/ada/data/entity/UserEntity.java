package com.ada.data.entity;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.ada.user.entity.UserInfo;

/**
 * 数据带用户信息的实体
 * 
 * @author ada
 *
 */
@MappedSuperclass
public class UserEntity extends AbstractEntity {

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
