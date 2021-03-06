package com.ada.user.service;

import com.ada.user.entity.UserGitHub;
import com.ada.user.page.UserGitHubPage;
import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;

public interface UserGitHubService {

	UserGitHub findById(Long id);
	
	UserGitHub login(String token);


	UserGitHub save(UserGitHub bean);

	UserGitHub update(UserGitHub bean);

	UserGitHub deleteById(Long id);
	
	UserGitHub[] deleteByIds(Long[] ids);
	
	UserGitHubPage getPage(int pageNo, int pageSize);
	
	
	Page<UserGitHub> findPage(Pageable pageable);

	long count(Filter... filters);

	List<UserGitHub> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}