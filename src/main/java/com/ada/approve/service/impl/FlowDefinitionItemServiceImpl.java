package com.ada.approve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.ada.approve.dao.FlowDefinitionItemDao;
import com.ada.approve.entity.FlowDefinitionItem;
import com.ada.approve.service.FlowDefinitionItemService;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;
@Service
@Transactional
public class FlowDefinitionItemServiceImpl implements FlowDefinitionItemService {
	
	
    
    
	@Transactional(readOnly = true)
	public FlowDefinitionItem findById(Long id) {
		FlowDefinitionItem entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public FlowDefinitionItem save(FlowDefinitionItem bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public FlowDefinitionItem update(FlowDefinitionItem bean) {
		Updater<FlowDefinitionItem> updater = new Updater<FlowDefinitionItem>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public FlowDefinitionItem deleteById(Long id) {
		FlowDefinitionItem bean = dao.findById(id);
		return bean;
	}

    @Transactional	
	public FlowDefinitionItem[] deleteByIds(Long[] ids) {
		FlowDefinitionItem[] beans = new FlowDefinitionItem[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private FlowDefinitionItemDao dao;

	@Autowired
	public void setDao(FlowDefinitionItemDao dao) {
		this.dao = dao;
	}
	
	
	@Transactional(readOnly = true)
	public Page<FlowDefinitionItem> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	@Transactional(readOnly = true)
	public long count(Filter... filters){
	     
	     return dao.count(filters);
	     
	}

	@Transactional(readOnly = true)
	public List<FlowDefinitionItem> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
	
		     return dao.findList(first,count,filters,orders);
	
	}
}