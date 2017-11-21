package com.ada.user.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quhaodian.data.core.CriteriaDaoImpl;
import com.quhaodian.data.core.Pagination;
import com.ada.user.dao.UserCodeDao;
import com.ada.user.entity.UserCode;

@Repository
public class UserCodeDaoImpl extends CriteriaDaoImpl<UserCode, Long> implements UserCodeDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public UserCode findById(Long id) {
		if (id == null) {
			return null;
		}
		UserCode entity = get(id);
		return entity;
	}

	public UserCode save(UserCode bean) {
		getSession().save(bean);

		return bean;
	}

	public UserCode deleteById(Long id) {
		UserCode entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}

	@Override
	protected Class<UserCode> getEntityClass() {
		return UserCode.class;
	}

	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public UserCode findByCode(String code) {
		List<UserCode> codes = findByProperty("code", code);
		if (codes!=null&&codes.size()>0) {
			return codes.get(0);
		}
		return null;
	}
}