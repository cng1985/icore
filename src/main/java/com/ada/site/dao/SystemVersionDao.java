package com.ada.site.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.site.entity.SystemVersion;

public interface SystemVersionDao extends CriteriaDao<SystemVersion,Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public SystemVersion findById(Long id);

	public SystemVersion save(SystemVersion bean);

	public SystemVersion updateByUpdater(Updater<SystemVersion> updater);

	public SystemVersion deleteById(Long id);
	
	public Long next(String sequence);
}