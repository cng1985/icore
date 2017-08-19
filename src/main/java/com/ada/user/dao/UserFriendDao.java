package com.ada.user.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.user.entity.UserFriend;

public interface UserFriendDao extends BaseDao<UserFriend, Long>{
	Pagination getPage(int pageNo, int pageSize);

	UserFriend findById(Long id);

	UserFriend save(UserFriend bean);

	UserFriend updateByUpdater(Updater<UserFriend> updater);

	UserFriend deleteById(Long id);
}