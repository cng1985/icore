package com.ada.activity.service;

import com.ada.activity.entity.ActivityCatalog;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年05月30日09:14:00.
*/
public interface ActivityCatalogService {

	public ActivityCatalog findById(Integer id);

	public ActivityCatalog save(ActivityCatalog bean);

	public ActivityCatalog update(ActivityCatalog bean);

	public ActivityCatalog deleteById(Integer id);
	
	public ActivityCatalog[] deleteByIds(Integer[] ids);
	
	public Page<ActivityCatalog> findPage(Pageable pageable);
	
	public Page<ActivityCatalog> page(Pageable pageable);
	
	public Page<ActivityCatalog> page(Pageable pageable, Object search);

	public long count(Filter... filters);

	public	List<ActivityCatalog> findByTops(Integer pid);

	public List<ActivityCatalog> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);

	List<ActivityCatalog>  findChild(int id);

}