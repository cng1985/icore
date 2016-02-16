package com.ada.approve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.ada.approve.dao.FlowDao;
import com.ada.approve.entity.Flow;
import com.ada.approve.service.FlowService;
import com.ada.approve.page.FlowPage;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


@Service
@Transactional
public class FlowServiceImpl implements FlowService {
	

	@Transactional(readOnly = true)
	public Flow findById(Long id) {
		Flow entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public Flow save(Flow bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public Flow update(Flow bean) {
		Updater<Flow> updater = new Updater<Flow>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public Flow deleteById(Long id) {
		Flow bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public Flow[] deleteByIds(Long[] ids) {
		Flow[] beans = new Flow[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private FlowDao dao;

	@Autowired
	public void setDao(FlowDao dao) {
		this.dao = dao;
	}
	
	@Transactional(readOnly = true)
	public FlowPage getPage(int pageNo, int pageSize) {
	    FlowPage result = null;
		Finder finder=Finder.create();
		finder.append("from Flow f ");
		finder.append(" order by f.id desc  ");
		Pagination<Flow> page = dao.find(finder,pageNo, pageSize);
		result = new FlowPage(page);
		return result;
	}
	
	
	@Transactional(readOnly = true)
	public Page<Flow> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	@Transactional(readOnly = true)
	public long count(Filter... filters){
	     
	     return dao.count(filters);
	     
	}

	@Transactional(readOnly = true)
	public List<Flow> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
	
		     return dao.findList(first,count,filters,orders);
	
	}
}