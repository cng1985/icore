package com.ada.approve.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.approve.dao.FlowApprovalDao;
import com.ada.approve.entity.FlowApproval;
import com.ada.data.core.CriteriaDaoImpl;
import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;

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
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public FlowApproval findNext(Long id, Integer hierarchy) {
		Finder finder = Finder.create();
		finder.append("from FlowApproval f where f.flow.id =:fid");
		finder.setParam("fid", id);
		finder.append(" and f.hierarchy =:hierarchy");
		finder.setParam("hierarchy", hierarchy + 1);
		finder.append(" order by f.hierarchy asc");
		List<FlowApproval> as = find(finder);
		if (as != null && as.size() > 0) {
			return as.get(0);
		} else {
			return null;
		}
	}

	@Override
	public FlowApproval findPre(Long id, Integer hierarchy) {
		Finder finder = Finder.create();
		finder.append("from FlowApproval f where f.flow.id =:fid");
		finder.setParam("fid", id);
		finder.append(" and f.hierarchy =:hierarchy");
		finder.setParam("hierarchy", hierarchy - 1);
		List<FlowApproval> as = find(finder);
		if (as != null && as.size() > 0) {
			return as.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<FlowApproval> findByFlow(Long id) {
		Finder finder = Finder.create();
		finder.append("from FlowApproval f where f.flow.id =:fid");
		finder.setParam("fid", id);
		finder.append(" order by f.id asc ");
		return find(finder);
	}

	@Override
	public FlowApproval findCur(Long id, Integer hierarchy) {
		Finder finder = Finder.create();
		finder.append("from FlowApproval f where f.flow.id =:fid");
		finder.setParam("fid", id);
		finder.append(" and f.hierarchy =:hierarchy");
		finder.setParam("hierarchy", hierarchy);
		List<FlowApproval> as = find(finder);
		if (as != null && as.size() > 0) {
			return as.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Integer deleteByFlow(Long id) {
		SQLQuery query = getSession().createSQLQuery("delete from approve_flow_approval where flow_id =:flow_id");
		query.setParameter("flow_id", id);
		return query.executeUpdate();
	}
}