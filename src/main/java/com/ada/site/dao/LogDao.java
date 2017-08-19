package com.ada.site.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.site.entity.Log;

public interface LogDao extends CriteriaDao<Log, Long>{
	Pagination getPage(int pageNo, int pageSize);

	Log findById(Long id);

	Log save(Log bean);

	Log updateByUpdater(Updater<Log> updater);

	Log deleteById(Long id);
}