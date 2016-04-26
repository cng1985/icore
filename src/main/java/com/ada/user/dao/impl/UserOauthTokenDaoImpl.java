package com.ada.user.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.data.core.Pagination;
import com.ada.user.dao.UserOauthTokenDao;
import com.ada.user.entity.UserOauthToken;

@Repository
public class UserOauthTokenDaoImpl extends CriteriaDaoImpl<UserOauthToken, Long> implements UserOauthTokenDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public UserOauthToken findById(Long id) {
	    if (id==null) {
			return null;
		}
		UserOauthToken entity = get(id);
		return entity;
	}

	public UserOauthToken save(UserOauthToken bean) {
		getSession().save(bean);
		return bean;
	}

	public UserOauthToken deleteById(Long id) {
		UserOauthToken entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<UserOauthToken> getEntityClass() {
		return UserOauthToken.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}