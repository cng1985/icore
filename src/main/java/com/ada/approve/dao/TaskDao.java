package com.ada.approve.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;

import java.util.Date;
import java.util.List;

import  com.ada.approve.entity.Task;

public interface TaskDao extends CriteriaDao<Task, Long>{
	Pagination getPage(int pageNo, int pageSize);

	Task findById(Long id);

	Task save(Task bean);
	
	int deleteForCatalog(Long oid, Integer catalog);


	Task updateByUpdater(Updater<Task> updater);

	Task deleteById(Long id);
	
	List<Date> list(long uid, int year, int month);
	
	
}