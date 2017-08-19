package com.ada.user.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.user.entity.UserOauthToken;

public interface UserOauthTokenDao extends CriteriaDao<UserOauthToken, Long>{
	Pagination getPage(int pageNo, int pageSize);

	UserOauthToken findById(Long id);
	
	UserOauthToken findByUid(String uid, String type);


	UserOauthToken save(UserOauthToken bean);

	UserOauthToken updateByUpdater(Updater<UserOauthToken> updater);

	UserOauthToken deleteById(Long id);
}