package com.ada.user.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.user.entity.UserLoginLog;

public interface UserLoginLogDao extends CriteriaDao<UserLoginLog,Long>{
	Pagination getPage(int pageNo, int pageSize);

	UserLoginLog findById(Long id);

	UserLoginLog save(UserLoginLog bean);

	UserLoginLog updateByUpdater(Updater<UserLoginLog> updater);

	UserLoginLog deleteById(Long id);
}