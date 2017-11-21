package com.ada.album.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quhaodian.data.core.CriteriaDaoImpl;
import com.quhaodian.data.core.Pagination;
import com.ada.album.dao.PhotoFeedDao;
import com.ada.album.entity.PhotoFeed;

@Repository
public class PhotoFeedDaoImpl extends CriteriaDaoImpl<PhotoFeed, String> implements PhotoFeedDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public PhotoFeed findById(String id) {
	    if (id==null) {
			return null;
		}
		PhotoFeed entity = get(id);
		return entity;
	}

	public PhotoFeed save(PhotoFeed bean) {
		getSession().save(bean);
		return bean;
	}

	public PhotoFeed deleteById(String id) {
		PhotoFeed entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<PhotoFeed> getEntityClass() {
		return PhotoFeed.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}