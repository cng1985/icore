package com.ada.user.service;

import com.ada.user.entity.UserCode;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


public interface UserCodeService {

	public UserCode findById(Long id);

	public UserCode save(UserCode bean);

	public UserCode update(UserCode bean);

	public UserCode deleteById(Long id);
	
	public UserCode[] deleteByIds(Long[] ids);
	
	public Page<UserCode> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<UserCode> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}