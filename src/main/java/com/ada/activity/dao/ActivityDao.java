package com.ada.activity.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.activity.entity.Activity;

public interface ActivityDao extends CriteriaDao<Activity, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public Activity findById(Long id);

	public Activity save(Activity bean);

	public Activity updateByUpdater(Updater<Activity> updater);

	public Activity deleteById(Long id);
}