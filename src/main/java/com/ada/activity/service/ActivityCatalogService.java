package com.ada.activity.service;

import com.ada.activity.entity.ActivityCatalog;
import com.ada.activity.page.ActivityCatalogPage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


public interface ActivityCatalogService {

	public ActivityCatalog findById(Integer id);

	public ActivityCatalog save(ActivityCatalog bean);

	public ActivityCatalog update(ActivityCatalog bean);

	public ActivityCatalog deleteById(Integer id);
	
	public ActivityCatalog[] deleteByIds(Integer[] ids);
	
	public ActivityCatalogPage getPage(int pageNo, int pageSize);
	
	
	public Page<ActivityCatalog> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<ActivityCatalog> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);

	public List<ActivityCatalog>  findChild(int id);
	
}