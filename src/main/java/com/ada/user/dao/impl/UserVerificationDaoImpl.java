package com.ada.user.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quhaodian.data.core.CriteriaDaoImpl;
import com.quhaodian.data.core.Finder;
import com.quhaodian.data.core.Pagination;
import com.ada.user.dao.UserVerificationDao;
import com.ada.user.entity.UserVerification;

@Repository
public class UserVerificationDaoImpl extends CriteriaDaoImpl<UserVerification, Long> implements UserVerificationDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public UserVerification findById(Long id) {
		UserVerification entity = get(id);
		return entity;
	}

	public UserVerification save(UserVerification bean) {
		getSession().save(bean);
		return bean;
	}

	public UserVerification deleteById(Long id) {
		UserVerification entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<UserVerification> getEntityClass() {
		return UserVerification.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}

	@Override
	public UserVerification findByName(String phone, Integer catalog) {
		
		Finder finder=Finder.create();
		finder.append("from UserVerification u where u.name =:name ");
		finder.setParam("name", phone);
		finder.append(" and u.catalog =:catalog ");
		finder.setParam("catalog", catalog);
		return findOne(finder);
	}
}