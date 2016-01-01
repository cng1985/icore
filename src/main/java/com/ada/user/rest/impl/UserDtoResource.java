package com.ada.user.rest.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Finder;
import com.ada.user.dao.UserInfoDao;
import com.ada.user.dto.UserDto;
import com.ada.user.entity.UserInfo;
import com.ada.user.rest.UserDtoApi;

@Service
@Transactional
public class UserDtoResource implements UserDtoApi {

	@Autowired
	private UserInfoDao dao;

	@Override
	public UserDto findByName(String username, String phone) {
		UserDto result = new UserDto();
		Finder finder = Finder.create("from UserInfo u where u.username =:username ");
		finder.setParam("username", username);
		finder.append(" and u.phone =:phone");
		finder.setParam("phone", phone);
		List<UserInfo> users = dao.find(finder);
		if (users != null && users.size() > 0) {
			BeanUtils.copyProperties(users.get(0), result);
		} else {
			result.setCode(-1);
			result.setMsg("没有该用户信息");
		}
		return result;
	}

}
