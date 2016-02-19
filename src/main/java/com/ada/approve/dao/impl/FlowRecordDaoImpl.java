package com.ada.approve.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.approve.dao.FlowRecordDao;
import com.ada.approve.entity.FlowRecord;

@Repository
public class FlowRecordDaoImpl extends CriteriaDaoImpl<FlowRecord, Long> implements FlowRecordDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public FlowRecord findById(Long id) {
		FlowRecord entity = get(id);
		return entity;
	}

	public FlowRecord save(FlowRecord bean) {
		getSession().save(bean);
		return bean;
	}

	public FlowRecord deleteById(Long id) {
		FlowRecord entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<FlowRecord> getEntityClass() {
		return FlowRecord.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}

	@Override
	public List<FlowRecord> findByFlow(Long id) {
		Finder finder=Finder.create();
		finder.append("from FlowRecord f where f.flow.id =:fid");
		finder.setParam("fid", id);
		finder.append(" order by f.id asc");
		
		return find(finder);
	}
}