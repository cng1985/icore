package com.ada.site.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.site.entity.SystemVersion;

public interface SystemVersionDao extends CriteriaDao<SystemVersion,Long>{
	Pagination getPage(int pageNo, int pageSize);

	SystemVersion findById(Long id);

	SystemVersion save(SystemVersion bean);

	SystemVersion updateByUpdater(Updater<SystemVersion> updater);

	SystemVersion deleteById(Long id);
	
	Long next(String sequence);
}