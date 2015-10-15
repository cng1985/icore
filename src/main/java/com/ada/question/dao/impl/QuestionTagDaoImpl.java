package com.ada.question.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.BaseDaoImpl;
import com.ada.data.core.Pagination;
import com.ada.question.dao.QuestionTagDao;
import com.ada.question.entity.QuestionTag;

@Repository
public class QuestionTagDaoImpl extends BaseDaoImpl<QuestionTag, Long> implements QuestionTagDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public QuestionTag findById(Long id) {
		QuestionTag entity = get(id);
		return entity;
	}

	public QuestionTag save(QuestionTag bean) {
		getSession().save(bean);
		return bean;
	}

	public QuestionTag deleteById(Long id) {
		QuestionTag entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<QuestionTag> getEntityClass() {
		return QuestionTag.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}