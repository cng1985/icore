package com.ada.user.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.data.core.Pagination;
import com.ada.user.dao.UserOauthWeiboDao;
import com.ada.user.entity.UserOauthWeibo;

@Repository
public class UserOauthWeiboDaoImpl extends CriteriaDaoImpl<UserOauthWeibo, Long> implements UserOauthWeiboDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public UserOauthWeibo findById(Long id) {
	    if (id==null) {
			return null;
		}
		UserOauthWeibo entity = get(id);
		return entity;
	}

	public UserOauthWeibo save(UserOauthWeibo bean) {
		getSession().save(bean);
		return bean;
	}

	public UserOauthWeibo deleteById(Long id) {
		UserOauthWeibo entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<UserOauthWeibo> getEntityClass() {
		return UserOauthWeibo.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}