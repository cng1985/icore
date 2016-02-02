package com.ada.user.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.data.core.Pagination;
import com.ada.user.dao.UserNotificationDao;
import com.ada.user.entity.UserNotification;

@Repository
public class UserNotificationDaoImpl extends CriteriaDaoImpl<UserNotification, Long> implements UserNotificationDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public UserNotification findById(Long id) {
		UserNotification entity = get(id);
		return entity;
	}

	public UserNotification save(UserNotification bean) {
		getSession().save(bean);
		return bean;
	}

	public UserNotification deleteById(Long id) {
		UserNotification entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<UserNotification> getEntityClass() {
		return UserNotification.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}