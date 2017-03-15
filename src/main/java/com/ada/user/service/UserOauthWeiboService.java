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

	public UserOauthWeibo findById(Long id);

	public UserOauthWeibo save(UserOauthWeibo bean);

	public UserOauthWeibo update(UserOauthWeibo bean);

	public UserOauthWeibo deleteById(Long id);
	
	public UserOauthWeibo[] deleteByIds(Long[] ids);
	
	public UserOauthWeiboPage getPage(int pageNo, int pageSize);
	
	
	public UserInfo login(String  token);

	
	
	public Page<UserOauthWeibo> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<UserOauthWeibo> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}