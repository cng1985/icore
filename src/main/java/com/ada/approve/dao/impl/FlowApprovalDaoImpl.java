package com.ada.approve.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.data.core.Pagination;
import com.ada.approve.dao.FlowApprovalDao;
import com.ada.approve.entity.FlowApproval;

@Repository
public class FlowApprovalDaoImpl extends CriteriaDaoImpl<FlowApproval, Long> implements FlowApprovalDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public FlowApproval findById(Long id) {
		FlowApproval entity = get(id);
		return entity;
	}

	public FlowApproval save(FlowApproval bean) {
		getSession().save(bean);
		return bean;
	}

	public FlowApproval deleteById(Long id) {
		FlowApproval entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<FlowApproval> getEntityClass() {
		return FlowApproval.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}