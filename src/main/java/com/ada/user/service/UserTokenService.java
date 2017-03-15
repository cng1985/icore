package com.ada.user.service;

import com.ada.user.entity.UserToken;
import com.ada.user.page.UserTokenPage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


public interface UserTokenService {

	public UserToken findById(Long id);

	public UserToken save(UserToken bean);

	public UserToken update(UserToken bean);

	public UserToken deleteById(Long id);
	
	public UserToken[] deleteByIds(Long[] ids);
	
	public UserTokenPage getPage(int pageNo, int pageSize);
	
	
	public Page<UserToken> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<UserToken> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}