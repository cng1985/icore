package com.ada.approve.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.approve.entity.Flow;

public interface FlowDao extends CriteriaDao<Flow, Long>{
	Pagination getPage(int pageNo, int pageSize);

	Flow findById(Long id);
	
	Flow findByOId(Integer catalog, Long id);

	int deleteForCatalog(Long oid, Integer catalog);

	Flow save(Flow bean);

	Flow updateByUpdater(Updater<Flow> updater);

	Flow deleteById(Long id);
}