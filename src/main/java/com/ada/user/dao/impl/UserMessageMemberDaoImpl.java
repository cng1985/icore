package com.ada.user.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quhaodian.data.core.CriteriaDaoImpl;
import com.quhaodian.data.core.Pagination;
import com.ada.user.dao.UserMessageMemberDao;
import com.ada.user.entity.UserMessageMember;

@Repository
public class UserMessageMemberDaoImpl extends CriteriaDaoImpl<UserMessageMember, Long> implements UserMessageMemberDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public UserMessageMember findById(Long id) {
		UserMessageMember entity = get(id);
		return entity;
	}

	public UserMessageMember save(UserMessageMember bean) {
		getSession().save(bean);
		return bean;
	}

	public UserMessageMember deleteById(Long id) {
		UserMessageMember entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<UserMessageMember> getEntityClass() {
		return UserMessageMember.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}