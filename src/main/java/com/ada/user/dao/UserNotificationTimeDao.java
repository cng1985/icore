package com.ada.user.dao;


import  com.ada.data.core.CriteriaDao;
import com.ada.data.core.Pagination;
import  com.ada.data.core.Updater;
import com.ada.user.entity.UserInfo;
import  com.ada.user.entity.UserNotificationTime;

public interface UserNotificationTimeDao extends CriteriaDao<UserNotificationTime, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public UserNotificationTime findById(Long id);
	
	
	public UserNotificationTime findByUser(Long id);

	public UserNotificationTime findByUser(UserInfo user);

	public UserNotificationTime save(UserNotificationTime bean);

	public UserNotificationTime updateByUpdater(Updater<UserNotificationTime> updater);

	public UserNotificationTime deleteById(Long id);
}