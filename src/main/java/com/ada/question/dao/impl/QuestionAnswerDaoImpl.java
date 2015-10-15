package com.ada.question.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.BaseDaoImpl;
import com.ada.data.core.Pagination;
import com.ada.question.dao.QuestionAnswerDao;
import com.ada.question.entity.QuestionAnswer;

@Repository
public class QuestionAnswerDaoImpl extends BaseDaoImpl<QuestionAnswer, Long> implements QuestionAnswerDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public QuestionAnswer findById(Long id) {
		QuestionAnswer entity = get(id);
		return entity;
	}

	public QuestionAnswer save(QuestionAnswer bean) {
		getSession().save(bean);
		return bean;
	}

	public QuestionAnswer deleteById(Long id) {
		QuestionAnswer entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<QuestionAnswer> getEntityClass() {
		return QuestionAnswer.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}