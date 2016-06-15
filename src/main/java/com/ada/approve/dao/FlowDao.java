package com.ada.approve.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.approve.entity.Flow;

public interface FlowDao extends CriteriaDao<Flow, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public Flow findById(Long id);
	
	public Flow findByOId(Integer catalog,Long id);

	public int deleteForCatalog(Long oid,Integer catalog);

	public Flow save(Flow bean);

	public Flow updateByUpdater(Updater<Flow> updater);

	public Flow deleteById(Long id);
}