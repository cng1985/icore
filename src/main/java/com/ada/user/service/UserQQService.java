package com.ada.user.service;

import com.ada.user.entity.UserQQ;
import com.ada.user.page.UserQQPage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


public interface UserQQService {

	UserQQ findById(Long id);

	UserQQ save(UserQQ bean);

	UserQQ update(UserQQ bean);

	UserQQ deleteById(Long id);
	
	UserQQ[] deleteByIds(Long[] ids);
	
	UserQQPage getPage(int pageNo, int pageSize);
	
	
	UserQQ login(String access_token, String openid, String oauth_consumer_key)throws Exception ;
	
	Page<UserQQ> findPage(Pageable pageable);

	long count(Filter... filters);

	List<UserQQ> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}