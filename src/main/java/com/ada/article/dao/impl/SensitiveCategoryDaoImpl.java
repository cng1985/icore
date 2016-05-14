package com.ada.article.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.data.core.Pagination;
import com.ada.article.dao.SensitiveCategoryDao;
import com.ada.article.entity.SensitiveCategory;

@Repository
public class SensitiveCategoryDaoImpl extends CriteriaDaoImpl<SensitiveCategory, Integer> implements SensitiveCategoryDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public SensitiveCategory findById(Integer id) {
	    if (id==null) {
			return null;
		}
		SensitiveCategory entity = get(id);
		return entity;
	}

	public SensitiveCategory save(SensitiveCategory bean) {
		getSession().save(bean);
		return bean;
	}

	public SensitiveCategory deleteById(Integer id) {
		SensitiveCategory entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<SensitiveCategory> getEntityClass() {
		return SensitiveCategory.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}