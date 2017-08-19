package com.ada.user.service;

import com.ada.user.entity.UserNotificationNum;
import com.ada.user.page.UserNotificationNumPage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

public interface UserNotificationNumService {

	UserNotificationNum findById(Long id);

	UserNotificationNum save(UserNotificationNum bean);

	UserNotificationNum update(UserNotificationNum bean);

	UserNotificationNum deleteById(Long id);
	
	UserNotificationNum[] deleteByIds(Long[] ids);
	
	UserNotificationNumPage getPage(int pageNo, int pageSize);
	
	
	Page<UserNotificationNum> findPage(Pageable pageable);

	long count(Filter... filters);

	List<UserNotificationNum> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}