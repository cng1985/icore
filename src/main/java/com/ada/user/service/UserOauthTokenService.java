package com.ada.user.service;

import com.ada.user.entity.UserOauthToken;
import com.ada.user.page.UserOauthTokenPage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

import com.openyelp.annotation.RestFul;

@RestFul(api=UserOauthTokenService.class,value="UserOauthTokenService")
public interface UserOauthTokenService {

	public UserOauthToken findById(Long id);

	public UserOauthToken save(UserOauthToken bean);

	public UserOauthToken update(UserOauthToken bean);

	public UserOauthToken deleteById(Long id);
	
	public UserOauthToken[] deleteByIds(Long[] ids);
	
	public UserOauthTokenPage getPage(int pageNo, int pageSize);
	
	
	public Page<UserOauthToken> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<UserOauthToken> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}