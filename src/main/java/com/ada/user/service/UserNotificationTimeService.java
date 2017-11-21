package com.ada.user.service;

import com.ada.user.entity.UserNotificationTime;
import com.ada.user.page.UserNotificationTimePage;
import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;


public interface UserNotificationTimeService {

	UserNotificationTime findById(Long id);

	UserNotificationTime save(UserNotificationTime bean);

	UserNotificationTime update(UserNotificationTime bean);

	UserNotificationTime deleteById(Long id);
	
	UserNotificationTime[] deleteByIds(Long[] ids);
	
	UserNotificationTimePage getPage(int pageNo, int pageSize);
	
	
	Page<UserNotificationTime> findPage(Pageable pageable);

	long count(Filter... filters);

	List<UserNotificationTime> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}