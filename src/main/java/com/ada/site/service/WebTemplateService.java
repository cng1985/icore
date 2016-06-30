package com.ada.site.service;

import com.ada.site.entity.WebTemplate;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

import com.openyelp.annotation.RestFul;

@RestFul(api=WebTemplateService.class,value="WebTemplateService")
public interface WebTemplateService {

	public WebTemplate findById(String id);

	public WebTemplate save(WebTemplate bean);

	public WebTemplate update(WebTemplate bean);

	public WebTemplate deleteById(String id);
	
	public WebTemplate[] deleteByIds(String[] ids);
	
	public Page<WebTemplate> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<WebTemplate> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}