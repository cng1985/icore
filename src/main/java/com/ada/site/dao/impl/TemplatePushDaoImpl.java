package com.ada.site.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quhaodian.data.core.CriteriaDaoImpl;
import com.quhaodian.data.core.Pagination;
import com.ada.site.dao.TemplatePushDao;
import com.ada.site.entity.TemplatePush;

@Repository
public class TemplatePushDaoImpl extends CriteriaDaoImpl<TemplatePush, String> implements TemplatePushDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public TemplatePush findById(String id) {
	    if (id==null) {
			return null;
		}
		TemplatePush entity = get(id);
		return entity;
	}

	public TemplatePush save(TemplatePush bean) {
		getSession().save(bean);
		return bean;
	}

	public TemplatePush deleteById(String id) {
		TemplatePush entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<TemplatePush> getEntityClass() {
		return TemplatePush.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}