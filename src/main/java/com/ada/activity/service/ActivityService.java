package com.ada.activity.service;

import com.ada.activity.entity.Activity;
import com.ada.activity.page.ActivityPage;
import com.ada.data.dto.PageRpc;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

import com.openyelp.annotation.RestFul;

@RestFul(api=ActivityService.class,value="ActivityService")
public interface ActivityService {

	public Activity findById(Long id);

	public Activity save(Activity bean);

	public Activity update(Activity bean);

	public Activity deleteById(Long id);
	
	public Activity[] deleteByIds(Long[] ids);
	
	public ActivityPage getPage(int pageNo, int pageSize);
	
	
	public Page<Activity> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<Activity> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);

	public ActivityPage pageByCatalog(int id, int curpage, int pagesize);
	
}