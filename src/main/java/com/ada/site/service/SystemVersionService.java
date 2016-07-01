package com.ada.site.service;

import com.ada.site.entity.SystemVersion;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

import com.openyelp.annotation.RestFul;

@RestFul(api=SystemVersionService.class,value="SystemVersionService")
public interface SystemVersionService {

	public SystemVersion findById(Long id);

	public SystemVersion save(SystemVersion bean);

	public SystemVersion update(SystemVersion bean);

	public SystemVersion deleteById(Long id);
	
	public SystemVersion[] deleteByIds(Long[] ids);
	
	public Page<SystemVersion> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<SystemVersion> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}