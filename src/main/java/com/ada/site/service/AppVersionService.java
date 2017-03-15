package com.ada.site.service;

import com.ada.site.entity.AppVersion;
import com.ada.site.page.AppVersionPage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


public interface AppVersionService {

	public AppVersion findById(Long id);

	public AppVersion save(AppVersion bean);

	public AppVersion update(AppVersion bean);

	public AppVersion deleteById(Long id);
	
	public AppVersion[] deleteByIds(Long[] ids);
	
	public AppVersionPage getPage(int pageNo, int pageSize);
	
	
	public Page<AppVersion> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<AppVersion> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}