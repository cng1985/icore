package com.ada.user.service;

import java.util.List;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import com.ada.user.entity.UserNotificationCatalog;
import com.ada.user.page.UserNotificationCatalogPage;
import com.openyelp.annotation.RestFul;

@RestFul(api=UserNotificationCatalogService.class,value="UserNotificationCatalogService")
public interface UserNotificationCatalogService {

	public UserNotificationCatalog findById(Integer id);
	
	
	public List<UserNotificationCatalog> findByPid(Integer id);


	public UserNotificationCatalog save(UserNotificationCatalog bean);

	public UserNotificationCatalog update(UserNotificationCatalog bean);

	public UserNotificationCatalog deleteById(Integer id);
	
	public UserNotificationCatalog[] deleteByIds(Integer[] ids);
	
	public UserNotificationCatalogPage getPage(int pageNo, int pageSize);
	
	
	public Page<UserNotificationCatalog> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<UserNotificationCatalog> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}