package com.ada.user.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quhaodian.data.core.CriteriaDaoImpl;
import com.quhaodian.data.core.Finder;
import com.quhaodian.data.core.Pagination;
import com.ada.user.dao.UserDeviceDao;
import com.ada.user.entity.UserDevice;

@Repository
public class UserDeviceDaoImpl extends CriteriaDaoImpl<UserDevice, Long> implements UserDeviceDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public UserDevice findById(Long id) {
		UserDevice entity = get(id);
		return entity;
	}

	public UserDevice save(UserDevice bean) {
		getSession().save(bean);
		return bean;
	}

	public UserDevice deleteById(Long id) {
		UserDevice entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<UserDevice> getEntityClass() {
		return UserDevice.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}

	@Override
	public UserDevice findByDevice(Long uid, String device) {
		Finder finder=Finder.create();
		finder.append("from UserDevice u where u.user.id =:uid and u.code =:device ");
		finder.setParam("uid", uid);
		finder.setParam("device", device);
		return findOne(finder);
	}
}