package com.ada.site.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.site.entity.App;

public interface AppDao extends CriteriaDao<App, Long>{
	Pagination getPage(int pageNo, int pageSize);

	App findById(Long id);

	
	App findByPackage(String packageName);

	
	App save(App bean);

	App updateByUpdater(Updater<App> updater);

	App deleteById(Long id);
}