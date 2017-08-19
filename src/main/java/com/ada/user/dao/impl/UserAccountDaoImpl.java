package com.ada.user.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.user.dao.UserAccountDao;
import com.ada.user.entity.UserAccount;

@Repository
public class UserAccountDaoImpl extends CriteriaDaoImpl<UserAccount, Long> implements UserAccountDao {

	@Override
	public UserAccount findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public UserAccount save(UserAccount bean) {
		getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public UserAccount deleteById(Long id) {
		UserAccount entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<UserAccount> getEntityClass() {
		return UserAccount.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}