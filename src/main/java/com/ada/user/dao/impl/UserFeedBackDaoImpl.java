package com.ada.user.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quhaodian.data.core.CriteriaDaoImpl;
import com.quhaodian.data.core.Pagination;
import com.ada.user.dao.UserFeedBackDao;
import com.ada.user.entity.UserFeedBack;

@Repository
public class UserFeedBackDaoImpl extends CriteriaDaoImpl<UserFeedBack, Long> implements UserFeedBackDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public UserFeedBack findById(Long id) {
		UserFeedBack entity = get(id);
		return entity;
	}

	public UserFeedBack save(UserFeedBack bean) {
		getSession().save(bean);
		return bean;
	}

	public UserFeedBack deleteById(Long id) {
		UserFeedBack entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<UserFeedBack> getEntityClass() {
		return UserFeedBack.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}