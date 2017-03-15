package com.ada.approve.service;

import com.ada.approve.entity.FlowDefinition;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


public interface FlowDefinitionService {

	public FlowDefinition findById(Long id);

	public FlowDefinition save(FlowDefinition bean);

	public FlowDefinition update(FlowDefinition bean);

	public FlowDefinition deleteById(Long id);
	
	public FlowDefinition[] deleteByIds(Long[] ids);
	
	public Page<FlowDefinition> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<FlowDefinition> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}