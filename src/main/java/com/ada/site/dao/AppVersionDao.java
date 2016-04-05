package com.ada.site.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.site.entity.AppVersion;

public interface AppVersionDao extends CriteriaDao<AppVersion, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public AppVersion findById(Long id);

	public AppVersion save(AppVersion bean);

	public AppVersion updateByUpdater(Updater<AppVersion> updater);

	public AppVersion deleteById(Long id);
}