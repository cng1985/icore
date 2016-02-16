package com.ada.approve.service;

import com.ada.approve.entity.Flow;
import com.ada.approve.page.FlowPage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

import com.openyelp.annotation.RestFul;

@RestFul(api=FlowService.class,value="FlowService")
public interface FlowService {

	public Flow findById(Long id);

	public Flow save(Flow bean);

	public Flow update(Flow bean);

	public Flow deleteById(Long id);
	
	public Flow[] deleteByIds(Long[] ids);
	
	public FlowPage getPage(int pageNo, int pageSize);
	
	
	public Page<Flow> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<Flow> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}