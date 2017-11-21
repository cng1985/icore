package com.ada.user.dao;


import  com.quhaodian.data.core.CriteriaDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import  com.ada.user.entity.UserNotificationCatalog;

public interface UserNotificationCatalogDao extends CriteriaDao<UserNotificationCatalog, Integer>{
	Pagination getPage(int pageNo, int pageSize);

	UserNotificationCatalog findById(Integer id);

	UserNotificationCatalog save(UserNotificationCatalog bean);

	UserNotificationCatalog updateByUpdater(Updater<UserNotificationCatalog> updater);

	UserNotificationCatalog deleteById(Integer id);
}