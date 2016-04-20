package com.ada.user.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.data.core.Pagination;
import com.ada.user.dao.UserOschinaDao;
import com.ada.user.entity.UserOschina;

@Repository
public class UserOschinaDaoImpl extends CriteriaDaoImpl<UserOschina, Long> implements UserOschinaDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public UserOschina findById(Long id) {
	    if (id==null) {
			return null;
		}
		UserOschina entity = get(id);
		return entity;
	}

	public UserOschina save(UserOschina bean) {
		getSession().save(bean);
		return bean;
	}

	public UserOschina deleteById(Long id) {
		UserOschina entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<UserOschina> getEntityClass() {
		return UserOschina.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}