package com.ada.user.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.user.entity.UserNotificationNum;

public interface UserNotificationNumDao extends CriteriaDao<UserNotificationNum, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public UserNotificationNum findById(Long id);

	public UserNotificationNum save(UserNotificationNum bean);

	public UserNotificationNum updateByUpdater(Updater<UserNotificationNum> updater);

	public UserNotificationNum deleteById(Long id);
}