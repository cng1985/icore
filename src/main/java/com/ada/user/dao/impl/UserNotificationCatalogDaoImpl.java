package com.ada.user.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quhaodian.data.core.CriteriaCatalogDaoImpl;
import com.quhaodian.data.core.Pagination;
import com.ada.user.dao.UserNotificationCatalogDao;
import com.ada.user.entity.UserNotificationCatalog;

@Repository
public class UserNotificationCatalogDaoImpl extends CriteriaCatalogDaoImpl<UserNotificationCatalog, Integer> implements UserNotificationCatalogDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public UserNotificationCatalog findById(Integer id) {
		UserNotificationCatalog entity = get(id);
		return entity;
	}

	public UserNotificationCatalog save(UserNotificationCatalog bean) {
		add(bean);
		return bean;
	}

	public UserNotificationCatalog deleteById(Integer id) {
		UserNotificationCatalog entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<UserNotificationCatalog> getEntityClass() {
		return UserNotificationCatalog.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}