package com.ada.user.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.user.entity.UserNotificationCatalog;

public interface UserNotificationCatalogDao extends CriteriaDao<UserNotificationCatalog, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public UserNotificationCatalog findById(Integer id);

	public UserNotificationCatalog save(UserNotificationCatalog bean);

	public UserNotificationCatalog updateByUpdater(Updater<UserNotificationCatalog> updater);

	public UserNotificationCatalog deleteById(Integer id);
}