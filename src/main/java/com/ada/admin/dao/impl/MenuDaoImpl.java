package com.ada.admin.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.admin.dao.MenuDao;
import com.ada.admin.entity.Menu;
import com.ada.data.core.CriteriaDaoImpl;
import com.ada.data.core.Pagination;

@Repository
public class MenuDaoImpl extends CriteriaDaoImpl<Menu, Integer> implements MenuDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public Menu findById(Integer id) {
		Menu entity = get(id);
		return entity;
	}

	public Menu save(Menu bean) {
		getSession().save(bean);
		return bean;
	}

	public Menu deleteById(Integer id) {
		Menu entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Menu> getEntityClass() {
		return Menu.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}