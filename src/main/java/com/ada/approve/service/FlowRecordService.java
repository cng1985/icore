package com.ada.approve.service;

import com.ada.approve.entity.FlowRecord;
import com.ada.approve.page.FlowRecordPage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

import com.openyelp.annotation.RestFul;

@RestFul(api=FlowRecordService.class,value="FlowRecordService")
public interface FlowRecordService {

	public FlowRecord findById(Long id);

	public FlowRecord save(FlowRecord bean);

	public FlowRecord update(FlowRecord bean);

	public FlowRecord deleteById(Long id);
	
	public FlowRecord[] deleteByIds(Long[] ids);
	
	public FlowRecordPage getPage(int pageNo, int pageSize);
	
	
	public Page<FlowRecord> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<FlowRecord> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}