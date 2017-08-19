package com.ada.user.service;

import com.ada.data.core.Pagination;
import com.ada.user.entity.UserFriendRequest;

public interface UserFriendRequestService {
	Pagination getPage(int pageNo, int pageSize);

	UserFriendRequest findById(Long id);

	UserFriendRequest save(UserFriendRequest bean);

	UserFriendRequest update(UserFriendRequest bean);

	UserFriendRequest deleteById(Long id);
	
	UserFriendRequest[] deleteByIds(Long[] ids);
	

	Pagination pageByUser(Long userid, String key, int pageNo, int pageSize);
	Pagination pageByUser(Long userid, int pageNo, int pageSize);
}