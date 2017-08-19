package com.ada.site.service;

import com.ada.site.entity.WebTemplate;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


public interface WebTemplateService {

	WebTemplate findById(String id);

	WebTemplate save(WebTemplate bean);

	WebTemplate update(WebTemplate bean);

	WebTemplate deleteById(String id);
	
	WebTemplate[] deleteByIds(String[] ids);
	
	Page<WebTemplate> findPage(Pageable pageable);

	long count(Filter... filters);

	List<WebTemplate> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}