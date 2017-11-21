package com.ada.album.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quhaodian.data.core.CriteriaDaoImpl;
import com.quhaodian.data.core.Pagination;
import com.ada.album.dao.CategoryDao;
import com.ada.album.entity.Category;

@Repository
public class CategoryDaoImpl extends CriteriaDaoImpl<Category, String> implements CategoryDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public Category findById(String id) {
		Category entity = get(id);
		return entity;
	}

	public Category save(Category bean) {
		getSession().save(bean);
		return bean;
	}

	public Category deleteById(String id) {
		Category entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Category> getEntityClass() {
		return Category.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}