package com.ada.user.service;

import com.ada.user.entity.UserInfo;
import com.ada.user.entity.UserOauthWeibo;
import com.ada.user.page.UserOauthWeiboPage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


public interface UserOauthWeiboService {

	UserOauthWeibo findById(Long id);

	UserOauthWeibo save(UserOauthWeibo bean);

	UserOauthWeibo update(UserOauthWeibo bean);

	UserOauthWeibo deleteById(Long id);
	
	UserOauthWeibo[] deleteByIds(Long[] ids);
	
	UserOauthWeiboPage getPage(int pageNo, int pageSize);
	
	
	UserInfo login(String token);

	
	
	Page<UserOauthWeibo> findPage(Pageable pageable);

	long count(Filter... filters);

	List<UserOauthWeibo> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}