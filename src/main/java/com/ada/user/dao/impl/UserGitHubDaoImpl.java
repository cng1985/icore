package com.ada.user.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quhaodian.data.core.CriteriaDaoImpl;
import com.quhaodian.data.core.Pagination;
import com.ada.user.dao.UserGitHubDao;
import com.ada.user.entity.UserGitHub;

@Repository
public class UserGitHubDaoImpl extends CriteriaDaoImpl<UserGitHub, Long> implements UserGitHubDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public UserGitHub findById(Long id) {
	    if (id==null) {
			return null;
		}
		UserGitHub entity = get(id);
		return entity;
	}

	public UserGitHub save(UserGitHub bean) {
		getSession().save(bean);
		return bean;
	}

	public UserGitHub deleteById(Long id) {
		UserGitHub entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<UserGitHub> getEntityClass() {
		return UserGitHub.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}