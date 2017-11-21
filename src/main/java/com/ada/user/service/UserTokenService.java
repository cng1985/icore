package com.ada.user.service;

import com.ada.user.entity.UserToken;
import com.ada.user.page.UserTokenPage;
import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;


public interface UserTokenService {

	UserToken findById(Long id);

	UserToken save(UserToken bean);

	UserToken update(UserToken bean);

	UserToken deleteById(Long id);
	
	UserToken[] deleteByIds(Long[] ids);
	
	UserTokenPage getPage(int pageNo, int pageSize);
	
	
	Page<UserToken> findPage(Pageable pageable);

	long count(Filter... filters);

	List<UserToken> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}