package com.ada.approve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.ada.approve.dao.FlowApprovalDao;
import com.ada.approve.entity.FlowApproval;
import com.ada.approve.service.FlowApprovalService;
import com.ada.approve.page.FlowApprovalPage;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


@Service
@Transactional
public class FlowApprovalServiceImpl implements FlowApprovalService {
	

	@Transactional(readOnly = true)
	public FlowApproval findById(Long id) {
		FlowApproval entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public FlowApproval save(FlowApproval bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public FlowApproval update(FlowApproval bean) {
		Updater<FlowApproval> updater = new Updater<FlowApproval>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public FlowApproval deleteById(Long id) {
		FlowApproval bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public FlowApproval[] deleteByIds(Long[] ids) {
		FlowApproval[] beans = new FlowApproval[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private FlowApprovalDao dao;

	@Autowired
	public void setDao(FlowApprovalDao dao) {
		this.dao = dao;
	}
	
	@Transactional(readOnly = true)
	public FlowApprovalPage getPage(int pageNo, int pageSize) {
	    FlowApprovalPage result = null;
		Finder finder=Finder.create();
		finder.append("from FlowApproval f ");
		finder.append(" order by f.id desc  ");
		Pagination<FlowApproval> page = dao.find(finder,pageNo, pageSize);
		result = new FlowApprovalPage(page);
		return result;
	}
	
	
	@Transactional(readOnly = true)
	public Page<FlowApproval> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	@Transactional(readOnly = true)
	public long count(Filter... filters){
	     
	     return dao.count(filters);
	     
	}

	@Transactional(readOnly = true)
	public List<FlowApproval> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
	
		     return dao.findList(first,count,filters,orders);
	
	}
}