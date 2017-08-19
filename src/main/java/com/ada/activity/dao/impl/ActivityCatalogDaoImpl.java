package com.ada.activity.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.activity.dao.ActivityCatalogDao;
import com.ada.activity.entity.ActivityCatalog;


/**
* Created by imake on 2017年05月30日09:14:00.
*/
@Repository
public class ActivityCatalogDaoImpl extends CriteriaDaoImpl<ActivityCatalog, Integer> implements ActivityCatalogDao {

	@Override
	public ActivityCatalog findById(Integer id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public ActivityCatalog save(ActivityCatalog bean) {
		getSession().save(bean);
		if (bean.getParentId() != null) {
			ActivityCatalog parent =findById(bean.getParentId());
			if (parent != null) {
				if (parent.getLevelInfo() != null) {
					bean.setLevelInfo(parent.getLevelInfo() + 1);
				} else {
					bean.setLevelInfo(2);
				}
				if (parent.getIds() != null) {
					bean.setIds(parent.getIds() + "," + bean.getId());

				} else {
					bean.setIds(parent.getId() + "," + bean.getId());
				}

			} else {
				bean.setLevelInfo(1);
				bean.setIds("" + bean.getId());
			}
		} else {
			bean.setLevelInfo(1);
			bean.setIds("" + bean.getId());
		}		
		
		
		return bean;
	}

    @Override
	public ActivityCatalog deleteById(Integer id) {
		ActivityCatalog entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<ActivityCatalog> getEntityClass() {
		return ActivityCatalog.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}