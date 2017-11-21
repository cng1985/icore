package com.ada.activity.dao;


import  com.quhaodian.data.core.CriteriaDao;
import  com.quhaodian.data.core.Updater;
import  com.ada.activity.entity.ActivityCatalog;

/**
* Created by imake on 2017年05月30日09:14:00.
*/
public interface ActivityCatalogDao extends CriteriaDao<ActivityCatalog,Integer>{

	public ActivityCatalog findById(Integer id);

	public ActivityCatalog save(ActivityCatalog bean);

	public ActivityCatalog updateByUpdater(Updater<ActivityCatalog> updater);

	public ActivityCatalog deleteById(Integer id);
}