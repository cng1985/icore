package com.ada.album.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.data.core.Pagination;
import com.ada.album.dao.TagDao;
import com.ada.album.entity.Tag;

@Repository
public class TagDaoImpl extends CriteriaDaoImpl<Tag, String> implements TagDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public Tag findById(String id) {
	    if (id==null) {
			return null;
		}
		Tag entity = get(id);
		return entity;
	}

	public Tag save(Tag bean) {
		getSession().save(bean);
		return bean;
	}

	public Tag deleteById(String id) {
		Tag entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Tag> getEntityClass() {
		return Tag.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}