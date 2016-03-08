package com.ada.activity.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.data.core.Pagination;
import com.ada.activity.dao.ActivityDao;
import com.ada.activity.entity.Activity;

@Repository
public class ActivityDaoImpl extends CriteriaDaoImpl<Activity, Long> implements ActivityDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public Activity findById(Long id) {
		Activity entity = get(id);
		return entity;
	}

	public Activity save(Activity bean) {
		getSession().save(bean);
		return bean;
	}

	public Activity deleteById(Long id) {
		Activity entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Activity> getEntityClass() {
		return Activity.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}