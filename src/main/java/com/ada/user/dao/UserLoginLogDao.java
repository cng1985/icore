package com.ada.user.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.user.entity.UserLoginLog;

public interface UserLoginLogDao extends CriteriaDao<UserLoginLog,Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public UserLoginLog findById(Long id);

	public UserLoginLog save(UserLoginLog bean);

	public UserLoginLog updateByUpdater(Updater<UserLoginLog> updater);

	public UserLoginLog deleteById(Long id);
}