package com.ada.site.service;

import com.ada.site.entity.LinkType;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年06月07日16:23:50.
*/
public interface LinkTypeService {

	public LinkType findById(Integer id);

	public LinkType save(LinkType bean);

	public LinkType update(LinkType bean);

	public LinkType deleteById(Integer id);
	
	public LinkType[] deleteByIds(Integer[] ids);
	
	public Page<LinkType> findPage(Pageable pageable);
	
	public Page<LinkType> page(Pageable pageable);
	
	public Page<LinkType> page(Pageable pageable, Object search);

	public long count(Filter... filters);

	public	List<LinkType> findByTops(Integer pid);

	public List<LinkType> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}