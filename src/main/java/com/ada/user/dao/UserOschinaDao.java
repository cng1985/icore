package com.ada.user.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.user.entity.UserOschina;

public interface UserOschinaDao extends CriteriaDao<UserOschina, Long>{
	Pagination getPage(int pageNo, int pageSize);

	UserOschina findById(Long id);

	UserOschina save(UserOschina bean);

	UserOschina updateByUpdater(Updater<UserOschina> updater);

	UserOschina deleteById(Long id);
}