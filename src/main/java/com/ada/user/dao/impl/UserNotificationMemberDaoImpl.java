package com.ada.user.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quhaodian.data.core.CriteriaDaoImpl;
import com.quhaodian.data.core.Pagination;
import com.ada.user.dao.UserNotificationMemberDao;
import com.ada.user.entity.UserNotificationMember;

@Repository
public class UserNotificationMemberDaoImpl extends CriteriaDaoImpl<UserNotificationMember, Long> implements UserNotificationMemberDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public UserNotificationMember findById(Long id) {
		UserNotificationMember entity = get(id);
		return entity;
	}

	public UserNotificationMember save(UserNotificationMember bean) {
		getSession().save(bean);
		return bean;
	}

	public UserNotificationMember deleteById(Long id) {
		UserNotificationMember entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<UserNotificationMember> getEntityClass() {
		return UserNotificationMember.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}