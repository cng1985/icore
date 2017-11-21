package com.ada.approve.service;

import com.ada.approve.entity.FlowDefinition;
import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;


public interface FlowDefinitionService {

	FlowDefinition findById(Long id);

	FlowDefinition save(FlowDefinition bean);

	FlowDefinition update(FlowDefinition bean);

	FlowDefinition deleteById(Long id);
	
	FlowDefinition[] deleteByIds(Long[] ids);
	
	Page<FlowDefinition> findPage(Pageable pageable);

	long count(Filter... filters);

	List<FlowDefinition> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}