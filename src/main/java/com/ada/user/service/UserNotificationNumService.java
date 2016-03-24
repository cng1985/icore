package com.ada.user.service;

import com.ada.user.entity.UserNotificationNum;
import com.ada.user.page.UserNotificationNumPage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

import com.openyelp.annotation.RestFul;

@RestFul(api=UserNotificationNumService.class,value="UserNotificationNumService")
public interface UserNotificationNumService {

	public UserNotificationNum findById(Long id);

	public UserNotificationNum save(UserNotificationNum bean);

	public UserNotificationNum update(UserNotificationNum bean);

	public UserNotificationNum deleteById(Long id);
	
	public UserNotificationNum[] deleteByIds(Long[] ids);
	
	public UserNotificationNumPage getPage(int pageNo, int pageSize);
	
	
	public Page<UserNotificationNum> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<UserNotificationNum> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}