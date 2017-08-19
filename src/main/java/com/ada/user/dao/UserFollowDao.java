package com.ada.user.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.user.entity.UserFollow;

public interface UserFollowDao extends BaseDao<UserFollow, Long>{
	Pagination getPage(int pageNo, int pageSize);

	UserFollow findById(Long id);

	UserFollow save(UserFollow bean);

	UserFollow updateByUpdater(Updater<UserFollow> updater);

	UserFollow deleteById(Long id);
	
	UserFollow findById(Long id, Long friendid);
}