package com.ada.question.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.data.core.Pagination;
import com.ada.question.dao.QuestionDao;
import com.ada.question.entity.Question;

@Repository
public class QuestionDaoImpl extends CriteriaDaoImpl<Question, Long> implements QuestionDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public Question findById(Long id) {
		Question entity = get(id);
		return entity;
	}

	public Question save(Question bean) {
		getSession().save(bean);
		return bean;
	}

	public Question deleteById(Long id) {
		Question entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Question> getEntityClass() {
		return Question.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}