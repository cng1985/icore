package com.ada.site.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.site.entity.AppVersion;

public interface AppVersionDao extends CriteriaDao<AppVersion, Long>{
	Pagination getPage(int pageNo, int pageSize);

	AppVersion findById(Long id);

	AppVersion save(AppVersion bean);

	AppVersion updateByUpdater(Updater<AppVersion> updater);

	AppVersion deleteById(Long id);
}