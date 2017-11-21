package com.ada.user.dao;


import  com.quhaodian.data.core.CriteriaDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import  com.ada.user.entity.UserOschina;

public interface UserOschinaDao extends CriteriaDao<UserOschina, Long>{
	Pagination getPage(int pageNo, int pageSize);

	UserOschina findById(Long id);

	UserOschina save(UserOschina bean);

	UserOschina updateByUpdater(Updater<UserOschina> updater);

	UserOschina deleteById(Long id);
}