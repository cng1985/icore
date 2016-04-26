package com.ada.user.service;

import com.ada.user.entity.UserGitHub;
import com.ada.user.page.UserGitHubPage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

import com.openyelp.annotation.RestFul;

@RestFul(api=UserGitHubService.class,value="UserGitHubService")
public interface UserGitHubService {

	public UserGitHub findById(Long id);
	
	public UserGitHub login(String token);


	public UserGitHub save(UserGitHub bean);

	public UserGitHub update(UserGitHub bean);

	public UserGitHub deleteById(Long id);
	
	public UserGitHub[] deleteByIds(Long[] ids);
	
	public UserGitHubPage getPage(int pageNo, int pageSize);
	
	
	public Page<UserGitHub> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<UserGitHub> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}