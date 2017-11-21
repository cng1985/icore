package com.ada.user.service;

import com.ada.user.entity.UserCode;
import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;


public interface UserCodeService {

	UserCode findById(Long id);

	UserCode save(UserCode bean);

	UserCode update(UserCode bean);

	UserCode deleteById(Long id);
	
	UserCode[] deleteByIds(Long[] ids);
	
	Page<UserCode> findPage(Pageable pageable);

	long count(Filter... filters);

	List<UserCode> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}