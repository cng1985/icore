package com.ada.site.service;

import com.ada.site.entity.Link;
import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年06月07日16:23:50.
*/
public interface LinkService {

	public Link findById(Long id);

	public Link save(Link bean);

	public Link update(Link bean);

	public Link deleteById(Long id);
	
	public Link[] deleteByIds(Long[] ids);
	
	public Page<Link> findPage(Pageable pageable);
	
	public Page<Link> page(Pageable pageable);
	
	public Page<Link> page(Pageable pageable, Object search);

	public long count(Filter... filters);


	public List<Link> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}