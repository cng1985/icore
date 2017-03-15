package com.ada.site.service;

import com.ada.site.entity.TemplatePush;
import com.ada.site.page.TemplatePushPage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


public interface TemplatePushService {

	public TemplatePush findById(String id);

	public TemplatePush save(TemplatePush bean);

	public TemplatePush update(TemplatePush bean);

	public TemplatePush deleteById(String id);
	
	public TemplatePush[] deleteByIds(String[] ids);
	
	public TemplatePushPage getPage(int pageNo, int pageSize);
	
	
	public Page<TemplatePush> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<TemplatePush> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}