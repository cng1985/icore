package com.ada.approve.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.data.core.Pagination;
import com.ada.approve.dao.FlowDefinitionDao;
import com.ada.approve.entity.FlowDefinition;

@Repository
public class FlowDefinitionDaoImpl extends CriteriaDaoImpl<FlowDefinition, Long> implements FlowDefinitionDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public FlowDefinition findById(Long id) {
	    if (id==null) {
			return null;
		}
		FlowDefinition entity = get(id);
		return entity;
	}

	public FlowDefinition save(FlowDefinition bean) {
		getSession().save(bean);
		
		
		return bean;
	}

	public FlowDefinition deleteById(Long id) {
		FlowDefinition entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<FlowDefinition> getEntityClass() {
		return FlowDefinition.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}