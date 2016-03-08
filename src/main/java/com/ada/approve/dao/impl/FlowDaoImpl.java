package com.ada.approve.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.approve.dao.FlowDao;
import com.ada.approve.entity.Flow;

@Repository
public class FlowDaoImpl extends CriteriaDaoImpl<Flow, Long> implements FlowDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public Flow findById(Long id) {
		Flow entity = get(id);
		return entity;
	}

	public Flow save(Flow bean) {
		getSession().save(bean);
		return bean;
	}

	public Flow deleteById(Long id) {
		Flow entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}

	@Override
	protected Class<Flow> getEntityClass() {
		return Flow.class;
	}

	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public Flow findByOId(Integer catalog, Long id) {
		Finder finder = Finder.create();
		finder.append("from Flow f where f.oid =:oid");
		finder.setParam("oid", id);
		finder.append("  and f.catalog =:catalog");
		finder.setParam("catalog", catalog);
		return findOne(finder);
	}
}