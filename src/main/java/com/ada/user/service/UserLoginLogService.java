package com.ada.user.service;

import com.ada.user.entity.UserLoginLog;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

import com.openyelp.annotation.RestFul;

@RestFul(api=UserLoginLogService.class,value="UserLoginLogService")
public interface UserLoginLogService {

	public UserLoginLog findById(Long id);

	public UserLoginLog save(UserLoginLog bean);

	public UserLoginLog update(UserLoginLog bean);

	public UserLoginLog deleteById(Long id);
	
	public UserLoginLog[] deleteByIds(Long[] ids);
	
	public Page<UserLoginLog> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<UserLoginLog> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}