package com.ada.activity.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.data.core.Pagination;
import com.ada.activity.dao.ActivityCatalogDao;
import com.ada.activity.entity.ActivityCatalog;

@Repository
public class ActivityCatalogDaoImpl extends CriteriaDaoImpl<ActivityCatalog, Integer> implements ActivityCatalogDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public ActivityCatalog findById(Integer id) {
		ActivityCatalog entity = get(id);
		return entity;
	}

	public ActivityCatalog save(ActivityCatalog bean) {
		getSession().save(bean);
		return bean;
	}

	public ActivityCatalog deleteById(Integer id) {
		ActivityCatalog entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<ActivityCatalog> getEntityClass() {
		return ActivityCatalog.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}