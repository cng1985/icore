package com.ada.user.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.data.core.Finder;
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
		if (id == null) {
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
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public UserOauthToken findByUid(String uid, String type) {
		UserOauthToken result =null;
		Finder finder = Finder.create("from UserOauthToken u where u.uid=:uid ");
		finder.append(" and u.token_type =:token_type");
		finder.setParam("uid", uid);
		finder.setParam("token_type", type);
		List<UserOauthToken> ts = find(finder);
		if (ts!=null&&ts.size()>0) {
			result=ts.get(0);
		}
		return result;
	}
}