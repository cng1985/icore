package com.ada.approve.service;

import com.ada.approve.entity.FlowRecord;
import com.ada.approve.page.FlowRecordPage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


public interface FlowRecordService {

	FlowRecord findById(Long id);

	/**
	 * 根据业务对象id 和类型查询流程
	 * 
	 * @param id
	 * @return
	 */
	List<FlowRecord>  findByObjectId(Long id, Integer catalog);

	FlowRecord save(FlowRecord bean);

	FlowRecord update(FlowRecord bean);

	FlowRecord deleteById(Long id);

	FlowRecord[] deleteByIds(Long[] ids);

	FlowRecordPage getPage(int pageNo, int pageSize);

	Page<FlowRecord> findPage(Pageable pageable);

	long count(Filter... filters);

	List<FlowRecord> findByFlow(Long flow);

	List<FlowRecord> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);

}