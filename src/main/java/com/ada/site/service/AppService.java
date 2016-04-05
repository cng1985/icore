package com.ada.site.service;

import com.ada.site.entity.App;
import com.ada.site.page.AppPage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

import com.openyelp.annotation.RestFul;

@RestFul(api=AppService.class,value="AppService")
public interface AppService {

	public App findById(Long id);

	public App save(App bean);

	public App update(App bean);

	public App deleteById(Long id);
	
	public App[] deleteByIds(Long[] ids);
	
	public AppPage getPage(int pageNo, int pageSize);
	
	
	public Page<App> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<App> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}