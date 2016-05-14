package com.ada.article.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.data.core.Pagination;
import com.ada.article.dao.SensitiveWordDao;
import com.ada.article.entity.SensitiveWord;

@Repository
public class SensitiveWordDaoImpl extends CriteriaDaoImpl<SensitiveWord, Long> implements SensitiveWordDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public SensitiveWord findById(Long id) {
	    if (id==null) {
			return null;
		}
		SensitiveWord entity = get(id);
		return entity;
	}

	public SensitiveWord save(SensitiveWord bean) {
		getSession().save(bean);
		
		
		return bean;
	}

	public SensitiveWord deleteById(Long id) {
		SensitiveWord entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<SensitiveWord> getEntityClass() {
		return SensitiveWord.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}