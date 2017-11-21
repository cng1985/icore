package com.ada.approve.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quhaodian.data.core.CriteriaDaoImpl;
import com.quhaodian.data.core.Finder;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.page.Filter;
import com.ada.approve.dao.FlowDao;
import com.ada.approve.entity.Flow;
import com.ada.approve.entity.Task;

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

	@Override
	public int deleteForCatalog(Long oid, Integer catalog) {
		int result = 0;
		List<Filter> filters = new ArrayList<Filter>();
		filters.add(Filter.eq("oid", oid));
		filters.add(Filter.eq("catalog", catalog));
		List<Flow> tasks = findList(0, 1000, filters, null);
		if (tasks != null && tasks.size() > 0) {
			result = tasks.size();
			for (Flow task : tasks) {
				delete(task);
			}
		}
		return result;
	}
}