package com.ada.user.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.user.entity.UserOschina;

public interface UserOschinaDao extends CriteriaDao<UserOschina, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public UserOschina findById(Long id);

	public UserOschina save(UserOschina bean);

	public UserOschina updateByUpdater(Updater<UserOschina> updater);

	public UserOschina deleteById(Long id);
}