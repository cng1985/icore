package com.ada.approve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quhaodian.data.core.Finder;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;
import com.ada.approve.dao.FlowDefinitionDao;
import com.ada.approve.entity.FlowDefinition;
import com.ada.approve.service.FlowDefinitionService;

import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;
@Service
@Transactional
public class FlowDefinitionServiceImpl implements FlowDefinitionService {
	
	
    
    
	@Transactional(readOnly = true)
	public FlowDefinition findById(Long id) {
		FlowDefinition entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public FlowDefinition save(FlowDefinition bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public FlowDefinition update(FlowDefinition bean) {
		Updater<FlowDefinition> updater = new Updater<FlowDefinition>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public FlowDefinition deleteById(Long id) {
		FlowDefinition bean = dao.findById(id);
		return bean;
	}

    @Transactional	
	public FlowDefinition[] deleteByIds(Long[] ids) {
		FlowDefinition[] beans = new FlowDefinition[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private FlowDefinitionDao dao;

	@Autowired
	public void setDao(FlowDefinitionDao dao) {
		this.dao = dao;
	}
	
	
	@Transactional(readOnly = true)
	public Page<FlowDefinition> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	@Transactional(readOnly = true)
	public long count(Filter... filters){
	     
	     return dao.count(filters);
	     
	}

	@Transactional(readOnly = true)
	public List<FlowDefinition> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
	
		     return dao.findList(first,count,filters,orders);
	
	}
}