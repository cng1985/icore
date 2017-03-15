package com.ada.approve.service;

import com.ada.approve.entity.FlowApproval;
import com.ada.approve.page.FlowApprovalPage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


public interface FlowApprovalService {

	public FlowApproval findById(Long id);

	public FlowApproval save(FlowApproval bean);

	public FlowApproval update(FlowApproval bean);

	public FlowApproval deleteById(Long id);
	
	public FlowApproval[] deleteByIds(Long[] ids);
	
	public FlowApprovalPage getPage(int pageNo, int pageSize);
	
	
	public Page<FlowApproval> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<FlowApproval> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}