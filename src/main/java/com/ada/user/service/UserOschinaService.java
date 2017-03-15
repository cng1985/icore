package com.ada.user.service;

import com.ada.user.entity.UserInfo;
import com.ada.user.entity.UserOschina;
import com.ada.user.entity.UserQQ;
import com.ada.user.page.UserOschinaPage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


public interface UserOschinaService {

	public UserOschina findById(Long id);

	public UserOschina save(UserOschina bean);

	public UserOschina update(UserOschina bean);

	public UserOschina deleteById(Long id);
	
	public UserOschina[] deleteByIds(Long[] ids);
	
	public UserOschinaPage getPage(int pageNo, int pageSize);
	
	
	public UserInfo login(String client_id,String client_secret,String grant_type,String redirect_uri,String code);

	
	public Page<UserOschina> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<UserOschina> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}