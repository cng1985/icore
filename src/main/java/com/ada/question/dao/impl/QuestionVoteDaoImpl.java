package com.ada.question.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.BaseDaoImpl;
import com.ada.data.core.Pagination;
import com.ada.question.dao.QuestionVoteDao;
import com.ada.question.entity.QuestionVote;

@Repository
public class QuestionVoteDaoImpl extends BaseDaoImpl<QuestionVote, Long> implements QuestionVoteDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public QuestionVote findById(Long id) {
		QuestionVote entity = get(id);
		return entity;
	}

	public QuestionVote save(QuestionVote bean) {
		getSession().save(bean);
		return bean;
	}

	public QuestionVote deleteById(Long id) {
		QuestionVote entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<QuestionVote> getEntityClass() {
		return QuestionVote.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}