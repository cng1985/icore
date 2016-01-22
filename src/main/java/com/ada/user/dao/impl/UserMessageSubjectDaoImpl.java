package com.ada.user.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.data.core.Pagination;
import com.ada.user.dao.UserMessageSubjectDao;
import com.ada.user.entity.UserMessageSubject;

@Repository
public class UserMessageSubjectDaoImpl extends CriteriaDaoImpl<UserMessageSubject, Long> implements UserMessageSubjectDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public UserMessageSubject findById(Long id) {
		UserMessageSubject entity = get(id);
		return entity;
	}

	public UserMessageSubject save(UserMessageSubject bean) {
		getSession().save(bean);
		return bean;
	}

	public UserMessageSubject deleteById(Long id) {
		UserMessageSubject entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<UserMessageSubject> getEntityClass() {
		return UserMessageSubject.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}