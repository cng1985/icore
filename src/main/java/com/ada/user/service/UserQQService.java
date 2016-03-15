package com.ada.user.service;

import com.ada.user.entity.UserQQ;
import com.ada.user.page.UserQQPage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

import com.openyelp.annotation.RestFul;

@RestFul(api=UserQQService.class,value="UserQQService")
public interface UserQQService {

	public UserQQ findById(Long id);

	public UserQQ save(UserQQ bean);

	public UserQQ update(UserQQ bean);

	public UserQQ deleteById(Long id);
	
	public UserQQ[] deleteByIds(Long[] ids);
	
	public UserQQPage getPage(int pageNo, int pageSize);
	
	
	public UserQQ login(String access_token, String openid, String oauth_consumer_key)throws Exception ;
	
	public Page<UserQQ> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<UserQQ> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}