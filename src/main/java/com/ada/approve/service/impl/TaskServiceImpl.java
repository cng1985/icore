package com.ada.approve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.ada.approve.dao.TaskDao;
import com.ada.approve.entity.Task;
import com.ada.approve.service.TaskService;
import com.ada.approve.page.TaskPage;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


@Service
@Transactional
public class TaskServiceImpl implements TaskService {
	

	@Transactional(readOnly = true)
	public Task findById(Long id) {
		Task entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public Task save(Task bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public Task update(Task bean) {
		Updater<Task> updater = new Updater<Task>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public Task deleteById(Long id) {
		Task bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public Task[] deleteByIds(Long[] ids) {
		Task[] beans = new Task[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private TaskDao dao;

	@Autowired
	public void setDao(TaskDao dao) {
		this.dao = dao;
	}
	
	@Transactional(readOnly = true)
	public TaskPage getPage(int pageNo, int pageSize) {
	    TaskPage result = null;
		Finder finder=Finder.create();
		finder.append("from Task f ");
		finder.append(" order by f.id desc  ");
		Pagination<Task> page = dao.find(finder,pageNo, pageSize);
		result = new TaskPage(page);
		return result;
	}
	
	
	@Transactional(readOnly = true)
	public Page<Task> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	@Transactional(readOnly = true)
	public long count(Filter... filters){
	     
	     return dao.count(filters);
	     
	}

	@Transactional(readOnly = true)
	public List<Task> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
	
		     return dao.findList(first,count,filters,orders);
	
	}
}