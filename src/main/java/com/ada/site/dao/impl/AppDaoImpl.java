package com.ada.site.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.site.dao.AppDao;
import com.ada.site.entity.App;

@Repository
public class AppDaoImpl extends CriteriaDaoImpl<App, Long> implements AppDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public App findById(Long id) {
	    if (id==null) {
			return null;
		}
		App entity = get(id);
		return entity;
	}

	public App save(App bean) {
		getSession().save(bean);
		return bean;
	}

	public App deleteById(Long id) {
		App entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<App> getEntityClass() {
		return App.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}

	@Override
	public App findByPackage(String packageName) {
		
		Finder finder=Finder.create();
		finder.append("from App app where app.packageName =:packageName ");
		finder.setParam("packageName", packageName);
		
		return findOne(finder);
	}
}