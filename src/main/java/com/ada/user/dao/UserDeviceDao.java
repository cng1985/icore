package com.ada.user.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.user.entity.UserDevice;

public interface UserDeviceDao extends CriteriaDao<UserDevice, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public UserDevice findById(Long id);

	public UserDevice save(UserDevice bean);

	public UserDevice updateByUpdater(Updater<UserDevice> updater);

	public UserDevice deleteById(Long id);
}