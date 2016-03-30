package com.ada.user.resource.conver;

import org.springframework.beans.BeanUtils;

import com.ada.data.rest.core.Conver;
import com.ada.user.entity.UserInfo;
import com.ada.user.rest.vo.UserVo;

public class UserVoConver implements Conver<UserVo, UserInfo>{

	public UserVo conver(UserInfo user) {
		if (user == null) {
			return null;
		}
		UserVo result = new UserVo();
		BeanUtils.copyProperties(user, result);
		return result;
	}
}
