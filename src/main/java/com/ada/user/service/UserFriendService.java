package com.ada.user.service;

import com.ada.data.core.Pagination;
import com.ada.user.entity.UserFriend;
import com.ada.user.page.UserFriendPage;



public interface UserFriendService {
	Pagination getPage(int pageNo, int pageSize);

	UserFriend findById(Long id);

	UserFriend save(UserFriend bean);

	UserFriend update(UserFriend bean);

	UserFriend deleteById(Long id);
	
	UserFriend[] deleteByIds(Long[] ids);
	
	
	UserFriendPage pageByUser(long userid,int pageNo, int pageSize);
	
	
	Pagination pageByUser(Long id, String key, int pageNo, int pageSize);
}