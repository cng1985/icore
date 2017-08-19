package com.ada.user.service;

import com.ada.user.entity.UserRole;
import com.ada.user.page.UserRolePage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


public interface UserRoleService {

	UserRole findById(Long id);

	UserRole save(UserRole bean);

	UserRole update(UserRole bean);

	UserRole deleteById(Long id);
	
	UserRole[] deleteByIds(Long[] ids);
	
	UserRolePage getPage(int pageNo, int pageSize);
	
	
	Page<UserRole> findPage(Pageable pageable);

	long count(Filter... filters);

	List<UserRole> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}