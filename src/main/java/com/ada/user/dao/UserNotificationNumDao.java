package com.ada.user.dao;


import  com.quhaodian.data.core.CriteriaDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import  com.ada.user.entity.UserNotificationNum;

public interface UserNotificationNumDao extends CriteriaDao<UserNotificationNum, Long>{
	Pagination getPage(int pageNo, int pageSize);

	UserNotificationNum findById(Long id);

	UserNotificationNum save(UserNotificationNum bean);

	UserNotificationNum updateByUpdater(Updater<UserNotificationNum> updater);

	UserNotificationNum deleteById(Long id);
}