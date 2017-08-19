package com.ada.user.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.user.entity.UserDevice;

public interface UserDeviceDao extends CriteriaDao<UserDevice, Long>{
	Pagination getPage(int pageNo, int pageSize);

	UserDevice findById(Long id);
	
	UserDevice findByDevice(Long uid, String device);


	UserDevice save(UserDevice bean);

	UserDevice updateByUpdater(Updater<UserDevice> updater);

	UserDevice deleteById(Long id);
}