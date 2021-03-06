package com.ada.site.service;

import com.ada.site.entity.Log;
import com.ada.site.page.LogPage;
import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;


public interface LogService {

	Log findById(Long id);

	Log save(Log bean);

	Log update(Log bean);

	Log deleteById(Long id);
	
	Log[] deleteByIds(Long[] ids);
	
	LogPage getPage(int pageNo, int pageSize);
	
	
	Page<Log> findPage(Pageable pageable);

	long count(Filter... filters);

	List<Log> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}