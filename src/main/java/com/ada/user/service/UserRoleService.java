package com.ada.user.service;

import com.ada.user.entity.UserRole;
import com.ada.user.page.UserRolePage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

import com.openyelp.annotation.RestFul;

@RestFul(api=UserRoleService.class,value="UserRoleService")
public interface UserRoleService {

	public UserRole findById(Long id);

	public UserRole save(UserRole bean);

	public UserRole update(UserRole bean);

	public UserRole deleteById(Long id);
	
	public UserRole[] deleteByIds(Long[] ids);
	
	public UserRolePage getPage(int pageNo, int pageSize);
	
	
	public Page<UserRole> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<UserRole> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}