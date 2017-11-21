package com.ada.site.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quhaodian.data.core.CriteriaDaoImpl;
import com.quhaodian.data.core.Pagination;
import com.ada.site.dao.TemplateNoticeDao;
import com.ada.site.entity.TemplateNotice;

@Repository
public class TemplateNoticeDaoImpl extends CriteriaDaoImpl<TemplateNotice, String> implements TemplateNoticeDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public TemplateNotice findById(String id) {
	    if (id==null) {
			return null;
		}
		TemplateNotice entity = get(id);
		return entity;
	}

	public TemplateNotice save(TemplateNotice bean) {
		getSession().save(bean);
		return bean;
	}

	public TemplateNotice deleteById(String id) {
		TemplateNotice entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<TemplateNotice> getEntityClass() {
		return TemplateNotice.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}