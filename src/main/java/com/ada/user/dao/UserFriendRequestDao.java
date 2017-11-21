package com.ada.user.dao;


import  com.quhaodian.data.core.BaseDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import  com.ada.user.entity.UserFriendRequest;

public interface UserFriendRequestDao extends BaseDao<UserFriendRequest, Long>{
	Pagination getPage(int pageNo, int pageSize);

	UserFriendRequest findById(Long id);

	UserFriendRequest save(UserFriendRequest bean);

	UserFriendRequest updateByUpdater(Updater<UserFriendRequest> updater);

	UserFriendRequest deleteById(Long id);
}