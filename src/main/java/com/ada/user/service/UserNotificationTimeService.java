package com.ada.user.service;

import com.ada.user.entity.UserNotificationTime;
import com.ada.user.page.UserNotificationTimePage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


public interface UserNotificationTimeService {

	public UserNotificationTime findById(Long id);

	public UserNotificationTime save(UserNotificationTime bean);

	public UserNotificationTime update(UserNotificationTime bean);

	public UserNotificationTime deleteById(Long id);
	
	public UserNotificationTime[] deleteByIds(Long[] ids);
	
	public UserNotificationTimePage getPage(int pageNo, int pageSize);
	
	
	public Page<UserNotificationTime> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<UserNotificationTime> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}