package com.ada.user.service;

import java.util.List;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import com.ada.user.entity.UserNotificationCatalog;
import com.ada.user.page.UserNotificationCatalogPage;


public interface UserNotificationCatalogService {

	UserNotificationCatalog findById(Integer id);
	
	
	List<UserNotificationCatalog> findByPid(Integer id);


	UserNotificationCatalog save(UserNotificationCatalog bean);

	UserNotificationCatalog update(UserNotificationCatalog bean);

	UserNotificationCatalog deleteById(Integer id);
	
	UserNotificationCatalog[] deleteByIds(Integer[] ids);
	
	UserNotificationCatalogPage getPage(int pageNo, int pageSize);
	
	
	Page<UserNotificationCatalog> findPage(Pageable pageable);

	long count(Filter... filters);

	List<UserNotificationCatalog> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);


	UserNotificationCatalogPage searchPage(String name);
	
}