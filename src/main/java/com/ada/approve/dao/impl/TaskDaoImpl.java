package com.ada.approve.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.data.core.Pagination;
import com.ada.approve.dao.TaskDao;
import com.ada.approve.entity.Task;

@Repository
public class TaskDaoImpl extends CriteriaDaoImpl<Task, Long> implements TaskDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public Task findById(Long id) {
		Task entity = get(id);
		return entity;
	}

	public Task save(Task bean) {
		getSession().save(bean);
		return bean;
	}

	public Task deleteById(Long id) {
		Task entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Task> getEntityClass() {
		return Task.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}