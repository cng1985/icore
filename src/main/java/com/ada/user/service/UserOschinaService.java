package com.ada.user.service;

import java.util.List;

import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import com.ada.user.entity.UserInfo;
import com.ada.user.entity.UserOschina;
import com.ada.user.page.UserOschinaPage;


public interface UserOschinaService {

	UserOschina findById(Long id);

	UserOschina save(UserOschina bean);

	UserOschina update(UserOschina bean);

	UserOschina deleteById(Long id);
	
	UserOschina[] deleteByIds(Long[] ids);
	
	UserOschinaPage getPage(int pageNo, int pageSize);
	
	
	UserInfo login(String client_id, String client_secret, String grant_type, String redirect_uri, String code);

	
	Page<UserOschina> findPage(Pageable pageable);

	long count(Filter... filters);

	List<UserOschina> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}