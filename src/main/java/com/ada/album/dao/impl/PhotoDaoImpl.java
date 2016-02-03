package com.ada.album.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.data.core.Pagination;
import com.ada.album.dao.PhotoDao;
import com.ada.album.entity.Photo;

@Repository
public class PhotoDaoImpl extends CriteriaDaoImpl<Photo, String> implements PhotoDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public Photo findById(String id) {
		Photo entity = get(id);
		return entity;
	}

	public Photo save(Photo bean) {
		getSession().save(bean);
		return bean;
	}

	public Photo deleteById(String id) {
		Photo entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Photo> getEntityClass() {
		return Photo.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}