package com.ada.user.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.data.core.Pagination;
import com.ada.user.dao.UserLoginLogDao;
import com.ada.user.entity.UserLoginLog;

@Repository
public class UserLoginLogDaoImpl extends CriteriaDaoImpl<UserLoginLog, Long> implements UserLoginLogDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public UserLoginLog findById(Long id) {
	    if (id==null) {
			return null;
		}
		UserLoginLog entity = get(id);
		return entity;
	}

	public UserLoginLog save(UserLoginLog bean) {
		getSession().save(bean);
		
		
		return bean;
	}

	public UserLoginLog deleteById(Long id) {
		UserLoginLog entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<UserLoginLog> getEntityClass() {
		return UserLoginLog.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}