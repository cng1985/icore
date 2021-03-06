package com.ada.site.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quhaodian.data.core.CriteriaDaoImpl;
import com.quhaodian.data.core.Pagination;
import com.ada.site.dao.AppVersionDao;
import com.ada.site.entity.AppVersion;

@Repository
public class AppVersionDaoImpl extends CriteriaDaoImpl<AppVersion, Long> implements AppVersionDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public AppVersion findById(Long id) {
	    if (id==null) {
			return null;
		}
		AppVersion entity = get(id);
		return entity;
	}

	public AppVersion save(AppVersion bean) {
		getSession().save(bean);
		return bean;
	}

	public AppVersion deleteById(Long id) {
		AppVersion entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<AppVersion> getEntityClass() {
		return AppVersion.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}