package com.ada.site.dao;


import  com.quhaodian.data.core.CriteriaDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import  com.ada.site.entity.Log;

public interface LogDao extends CriteriaDao<Log, Long>{
	Pagination getPage(int pageNo, int pageSize);

	Log findById(Long id);

	Log save(Log bean);

	Log updateByUpdater(Updater<Log> updater);

	Log deleteById(Long id);
}