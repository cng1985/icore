package com.ada.user.vo;

import com.quhaodian.data.vo.StateVo;
import com.ada.user.entity.UserInfo;

public class UserStateVo extends StateVo {

	private UserInfo user;

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}
	
}
