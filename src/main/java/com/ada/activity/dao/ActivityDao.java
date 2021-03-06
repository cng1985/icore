package com.ada.activity.dao;


import  com.quhaodian.data.core.CriteriaDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import  com.ada.activity.entity.Activity;

public interface ActivityDao extends CriteriaDao<Activity, Long>{
	Pagination getPage(int pageNo, int pageSize);

	Activity findById(Long id);

	Activity save(Activity bean);

	Activity updateByUpdater(Updater<Activity> updater);

	Activity deleteById(Long id);
}