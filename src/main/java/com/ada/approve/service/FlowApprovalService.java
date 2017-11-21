package com.ada.approve.service;

import com.ada.approve.entity.FlowApproval;
import com.ada.approve.page.FlowApprovalPage;
import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;


public interface FlowApprovalService {

	FlowApproval findById(Long id);

	FlowApproval save(FlowApproval bean);

	FlowApproval update(FlowApproval bean);

	FlowApproval deleteById(Long id);
	
	FlowApproval[] deleteByIds(Long[] ids);
	
	FlowApprovalPage getPage(int pageNo, int pageSize);
	
	
	Page<FlowApproval> findPage(Pageable pageable);

	long count(Filter... filters);

	List<FlowApproval> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}