package com.ada.user.dao;


import  com.quhaodian.data.core.CriteriaDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import  com.ada.user.entity.UserToken;

public interface UserTokenDao extends CriteriaDao<UserToken, Long>{
	Pagination getPage(int pageNo, int pageSize);

	UserToken findById(Long id);
	UserToken findById(Long uid, Integer catalog);

	UserToken save(UserToken bean);

	UserToken updateByUpdater(Updater<UserToken> updater);

	UserToken deleteById(Long id);
}