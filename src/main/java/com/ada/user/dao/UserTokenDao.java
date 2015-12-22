package com.ada.user.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.user.entity.UserToken;

public interface UserTokenDao extends CriteriaDao<UserToken, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public UserToken findById(Long id);

	public UserToken save(UserToken bean);

	public UserToken updateByUpdater(Updater<UserToken> updater);

	public UserToken deleteById(Long id);
}