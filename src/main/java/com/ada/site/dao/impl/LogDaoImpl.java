package com.ada.site.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quhaodian.data.core.CriteriaDaoImpl;
import com.quhaodian.data.core.Pagination;
import com.ada.site.dao.LogDao;
import com.ada.site.entity.Log;

@Repository
public class LogDaoImpl extends CriteriaDaoImpl<Log, Long> implements LogDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public Log findById(Long id) {
	    if (id==null) {
			return null;
		}
		Log entity = get(id);
		return entity;
	}

	public Log save(Log bean) {
		getSession().save(bean);
		return bean;
	}

	public Log deleteById(Long id) {
		Log entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Log> getEntityClass() {
		return Log.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}