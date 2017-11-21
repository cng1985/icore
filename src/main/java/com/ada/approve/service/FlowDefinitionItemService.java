package com.ada.approve.service;

import com.ada.approve.entity.FlowDefinitionItem;
import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;


public interface FlowDefinitionItemService {

	FlowDefinitionItem findById(Long id);

	FlowDefinitionItem save(FlowDefinitionItem bean);

	FlowDefinitionItem update(FlowDefinitionItem bean);

	FlowDefinitionItem deleteById(Long id);
	
	FlowDefinitionItem[] deleteByIds(Long[] ids);
	
	Page<FlowDefinitionItem> findPage(Pageable pageable);

	long count(Filter... filters);

	List<FlowDefinitionItem> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}