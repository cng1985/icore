package com.ada.question.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.BaseDaoImpl;
import com.ada.data.core.Pagination;
import com.ada.question.dao.QuestionFavoriteDao;
import com.ada.question.entity.QuestionFavorite;

@Repository
public class QuestionFavoriteDaoImpl extends BaseDaoImpl<QuestionFavorite, Long> implements QuestionFavoriteDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public QuestionFavorite findById(Long id) {
		QuestionFavorite entity = get(id);
		return entity;
	}

	public QuestionFavorite save(QuestionFavorite bean) {
		getSession().save(bean);
		return bean;
	}

	public QuestionFavorite deleteById(Long id) {
		QuestionFavorite entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<QuestionFavorite> getEntityClass() {
		return QuestionFavorite.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}