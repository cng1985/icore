package com.ada.site.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.site.entity.Log;

public interface LogDao extends CriteriaDao<Log, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public Log findById(Long id);

	public Log save(Log bean);

	public Log updateByUpdater(Updater<Log> updater);

	public Log deleteById(Long id);
}