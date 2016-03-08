package com.ada.activity.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.activity.entity.ActivityCatalog;

public interface ActivityCatalogDao extends CriteriaDao<ActivityCatalog, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public ActivityCatalog findById(Integer id);

	public ActivityCatalog save(ActivityCatalog bean);

	public ActivityCatalog updateByUpdater(Updater<ActivityCatalog> updater);

	public ActivityCatalog deleteById(Integer id);
}