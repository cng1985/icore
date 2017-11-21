package com.ada.approve.dao.impl;

import com.quhaodian.data.core.Finder;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quhaodian.data.core.CriteriaDaoImpl;
import com.quhaodian.data.core.Pagination;
import com.ada.approve.dao.FlowDefinitionItemDao;
import com.ada.approve.entity.FlowDefinitionItem;

@Repository
public class FlowDefinitionItemDaoImpl extends CriteriaDaoImpl<FlowDefinitionItem, Long> implements FlowDefinitionItemDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public FlowDefinitionItem findById(Long id) {
	    if (id==null) {
			return null;
		}
		FlowDefinitionItem entity = get(id);
		return entity;
	}

	@Override
	public FlowDefinitionItem findByDefintion(Long flow, Integer hierarchy) {
		Finder finder=Finder.create();
		finder.append("from FlowDefinitionItem f where f.flow.id=:flow and f.hierarchy=:hierarchy");
		finder.setParam("flow",flow);
		finder.setParam("hierarchy",hierarchy);
		return findOne(finder);
	}

	public FlowDefinitionItem save(FlowDefinitionItem bean) {
		getSession().save(bean);
		
		
		return bean;
	}

	public FlowDefinitionItem deleteById(Long id) {
		FlowDefinitionItem entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<FlowDefinitionItem> getEntityClass() {
		return FlowDefinitionItem.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}