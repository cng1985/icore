package com.ada.user.service;

import com.ada.user.entity.UserOauthToken;
import com.ada.user.page.UserOauthTokenPage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


public interface UserOauthTokenService {

	UserOauthToken findById(Long id);


	UserOauthToken findByUid(String uid);


	UserOauthToken save(UserOauthToken bean);

	UserOauthToken update(UserOauthToken bean);

	UserOauthToken deleteById(Long id);
	
	UserOauthToken[] deleteByIds(Long[] ids);
	
	UserOauthTokenPage getPage(int pageNo, int pageSize);
	
	
	Page<UserOauthToken> findPage(Pageable pageable);

	long count(Filter... filters);

	List<UserOauthToken> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}