package com.ada.user.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.user.entity.UserOauthToken;

public interface UserOauthTokenDao extends CriteriaDao<UserOauthToken, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public UserOauthToken findById(Long id);

	public UserOauthToken save(UserOauthToken bean);

	public UserOauthToken updateByUpdater(Updater<UserOauthToken> updater);

	public UserOauthToken deleteById(Long id);
}