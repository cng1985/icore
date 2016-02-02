package com.ada.user.dao;


import com.ada.data.core.CriteriaDao;
import com.ada.data.core.Pagination;
import  com.ada.data.core.Updater;
import  com.ada.user.entity.UserNotification;

public interface UserNotificationDao extends CriteriaDao<UserNotification, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public UserNotification findById(Long id);

	public UserNotification save(UserNotification bean);

	public UserNotification updateByUpdater(Updater<UserNotification> updater);

	public UserNotification deleteById(Long id);
}