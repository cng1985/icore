package com.ada.approve.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;

import java.util.Date;
import java.util.List;

import  com.ada.approve.entity.Task;

public interface TaskDao extends CriteriaDao<Task, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public Task findById(Long id);

	public Task save(Task bean);
	
	public int deleteForCatalog(Long oid,Integer catalog);


	public Task updateByUpdater(Updater<Task> updater);

	public Task deleteById(Long id);
	
	public List<Date> list(long uid, int year, int month);
	
	
}