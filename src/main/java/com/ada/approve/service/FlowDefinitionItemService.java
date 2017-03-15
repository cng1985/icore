package com.ada.approve.service;

import com.ada.approve.entity.FlowDefinitionItem;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


public interface FlowDefinitionItemService {

	public FlowDefinitionItem findById(Long id);

	public FlowDefinitionItem save(FlowDefinitionItem bean);

	public FlowDefinitionItem update(FlowDefinitionItem bean);

	public FlowDefinitionItem deleteById(Long id);
	
	public FlowDefinitionItem[] deleteByIds(Long[] ids);
	
	public Page<FlowDefinitionItem> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<FlowDefinitionItem> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}