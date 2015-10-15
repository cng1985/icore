package com.ada.user.service;

import com.ada.data.core.Pagination;
import com.ada.user.entity.UserFriend;
import com.ada.user.page.UserFriendPage;
import com.openyelp.annotation.RestFul;



@RestFul(api=UserFriendService.class,value="UserFriendService")
public interface UserFriendService {
	public Pagination getPage(int pageNo, int pageSize);

	public UserFriend findById(Long id);

	public UserFriend save(UserFriend bean);

	public UserFriend update(UserFriend bean);

	public UserFriend deleteById(Long id);
	
	public UserFriend[] deleteByIds(Long[] ids);
	
	
	UserFriendPage pageByUser(long userid,int pageNo, int pageSize);
}