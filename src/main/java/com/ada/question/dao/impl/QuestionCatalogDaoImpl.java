package com.ada.question.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.BaseDaoImpl;
import com.ada.data.core.Pagination;
import com.ada.question.dao.QuestionCatalogDao;
import com.ada.question.entity.QuestionCatalog;

@Repository
public class QuestionCatalogDaoImpl extends BaseDaoImpl<QuestionCatalog, Integer> implements QuestionCatalogDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public QuestionCatalog findById(Integer id) {
		QuestionCatalog entity = get(id);
		return entity;
	}

	public QuestionCatalog save(QuestionCatalog bean) {
		getSession().save(bean);
		return bean;
	}

	public QuestionCatalog deleteById(Integer id) {
		QuestionCatalog entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<QuestionCatalog> getEntityClass() {
		return QuestionCatalog.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}