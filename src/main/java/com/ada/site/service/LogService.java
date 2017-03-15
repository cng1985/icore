package com.ada.site.service;

import com.ada.site.entity.Log;
import com.ada.site.page.LogPage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


public interface LogService {

	public Log findById(Long id);

	public Log save(Log bean);

	public Log update(Log bean);

	public Log deleteById(Long id);
	
	public Log[] deleteByIds(Long[] ids);
	
	public LogPage getPage(int pageNo, int pageSize);
	
	
	public Page<Log> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<Log> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}