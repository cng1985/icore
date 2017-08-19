package com.ada.user.dao;


import  com.ada.data.core.CriteriaDao;
import com.ada.data.core.Pagination;
import  com.ada.data.core.Updater;
import com.ada.user.entity.UserInfo;
import  com.ada.user.entity.UserNotificationTime;

public interface UserNotificationTimeDao extends CriteriaDao<UserNotificationTime, Long>{
	Pagination getPage(int pageNo, int pageSize);

	UserNotificationTime findById(Long id);
	
	
	UserNotificationTime findByUser(Long id);

	UserNotificationTime findByUser(UserInfo user);

	UserNotificationTime save(UserNotificationTime bean);

	UserNotificationTime updateByUpdater(Updater<UserNotificationTime> updater);

	UserNotificationTime deleteById(Long id);
}