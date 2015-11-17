package com.ada.album.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.BaseDaoImpl;
import com.ada.data.core.Pagination;
import com.ada.album.dao.AlbumDao;
import com.ada.album.entity.Album;

@Repository
public class AlbumDaoImpl extends BaseDaoImpl<Album, Long> implements AlbumDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public Album findById(Long id) {
		Album entity = get(id);
		return entity;
	}

	public Album save(Album bean) {
		getSession().save(bean);
		return bean;
	}

	public Album deleteById(Long id) {
		Album entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Album> getEntityClass() {
		return Album.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}