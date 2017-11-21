package com.ada.activity.service;

import java.util.List;

import com.ada.activity.entity.Activity;
import com.ada.activity.page.ActivityPage;
import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;


public interface ActivityService {

	Activity findById(Long id);

	Activity save(Activity bean);

	Activity update(Activity bean);

	Activity deleteById(Long id);
	
	Activity[] deleteByIds(Long[] ids);
	
	ActivityPage getPage(int pageNo, int pageSize);
	
	
	Page<Activity> findPage(Pageable pageable);

	long count(Filter... filters);

	List<Activity> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);

	ActivityPage pageByCatalog(int id, int curpage, int pagesize);
	
}