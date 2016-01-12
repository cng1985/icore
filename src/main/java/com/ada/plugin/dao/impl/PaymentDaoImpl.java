package com.ada.plugin.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.data.core.Pagination;
import com.ada.plugin.dao.PaymentDao;
import com.ada.plugin.entity.Payment;

@Repository
public class PaymentDaoImpl extends CriteriaDaoImpl<Payment, Long> implements PaymentDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public Payment findById(Long id) {
		Payment entity = get(id);
		return entity;
	}

	public Payment save(Payment bean) {
		getSession().save(bean);
		return bean;
	}

	public Payment deleteById(Long id) {
		Payment entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Payment> getEntityClass() {
		return Payment.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}