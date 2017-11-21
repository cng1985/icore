package com.ada.user.dao;


import com.quhaodian.data.core.CriteriaDao;
import com.quhaodian.data.core.Pagination;
import  com.quhaodian.data.core.Updater;
import  com.ada.user.entity.UserNotification;

public interface UserNotificationDao extends CriteriaDao<UserNotification, Long>{
	Pagination getPage(int pageNo, int pageSize);

	UserNotification findById(Long id);

	UserNotification save(UserNotification bean);

	UserNotification updateByUpdater(Updater<UserNotification> updater);

	UserNotification deleteById(Long id);
}