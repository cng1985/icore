package com.ada.site.service;

import com.ada.site.entity.App;
import com.ada.site.page.AppPage;
import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;


public interface AppService {


	public String key();

	public String secret();

	App findById(Long id);

	App visit(Long id);


	App save(App bean);

	App update(App bean);

	App deleteById(Long id);
	
	App[] deleteByIds(Long[] ids);


	Page<App> page(Pageable pageable);

	Page<App> findPage(Pageable pageable);

	long count(Filter... filters);

	List<App> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}