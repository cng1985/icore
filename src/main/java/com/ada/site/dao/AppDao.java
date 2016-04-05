package com.ada.site.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.site.entity.App;

public interface AppDao extends CriteriaDao<App, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public App findById(Long id);

	
	public App findByPackage(String packageName);

	
	public App save(App bean);

	public App updateByUpdater(Updater<App> updater);

	public App deleteById(Long id);
}