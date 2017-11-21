package com.ada.user.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quhaodian.data.core.CriteriaDaoImpl;
import com.quhaodian.data.core.Pagination;
import com.ada.user.dao.UserNotificationNumDao;
import com.ada.user.entity.UserNotificationNum;

@Repository
public class UserNotificationNumDaoImpl extends CriteriaDaoImpl<UserNotificationNum, Long> implements UserNotificationNumDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public UserNotificationNum findById(Long id) {
	    if (id==null) {
			return null;
		}
		UserNotificationNum entity = get(id);
		return entity;
	}

	public UserNotificationNum save(UserNotificationNum bean) {
		getSession().save(bean);
		return bean;
	}

	public UserNotificationNum deleteById(Long id) {
		UserNotificationNum entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<UserNotificationNum> getEntityClass() {
		return UserNotificationNum.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}