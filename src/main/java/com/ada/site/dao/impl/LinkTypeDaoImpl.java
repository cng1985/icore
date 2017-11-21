package com.ada.site.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quhaodian.data.core.CriteriaDaoImpl;
import com.ada.site.dao.LinkTypeDao;
import com.ada.site.entity.LinkType;


/**
* Created by imake on 2017年06月07日16:23:50.
*/
@Repository
public class LinkTypeDaoImpl extends CriteriaDaoImpl<LinkType, Integer> implements LinkTypeDao {

	@Override
	public LinkType findById(Integer id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public LinkType save(LinkType bean) {
		getSession().save(bean);
		if (bean.getParentId() != null) {
			LinkType parent =findById(bean.getParentId());
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
	public LinkType deleteById(Integer id) {
		LinkType entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<LinkType> getEntityClass() {
		return LinkType.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}