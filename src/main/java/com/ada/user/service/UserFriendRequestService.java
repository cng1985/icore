package com.ada.user.service;

import com.ada.data.core.Pagination;
import com.ada.user.entity.UserFriendRequest;

import com.openyelp.annotation.RestFul;

@RestFul(api=UserFriendRequestService.class,value="UserFriendRequestService")
public interface UserFriendRequestService {
	public Pagination getPage(int pageNo, int pageSize);

	public UserFriendRequest findById(Long id);

	public UserFriendRequest save(UserFriendRequest bean);

	public UserFriendRequest update(UserFriendRequest bean);

	public UserFriendRequest deleteById(Long id);
	
	public UserFriendRequest[] deleteByIds(Long[] ids);
}