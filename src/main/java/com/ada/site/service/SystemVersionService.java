package com.ada.site.service;

import com.ada.site.entity.SystemVersion;
import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;

public interface SystemVersionService {

	SystemVersion findById(Long id);

	SystemVersion save(SystemVersion bean);

	SystemVersion update(SystemVersion bean);

	SystemVersion deleteById(Long id);
	
	SystemVersion[] deleteByIds(Long[] ids);
	
	Page<SystemVersion> findPage(Pageable pageable);

	long count(Filter... filters);

	List<SystemVersion> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}