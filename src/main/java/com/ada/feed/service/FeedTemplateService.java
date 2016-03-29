package com.ada.feed.service;

import com.ada.feed.entity.FeedTemplate;
import com.ada.feed.page.FeedTemplatePage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

import com.openyelp.annotation.RestFul;

@RestFul(api=FeedTemplateService.class,value="FeedTemplateService")
public interface FeedTemplateService {

	public FeedTemplate findById(String id);

	public FeedTemplate save(FeedTemplate bean);

	public FeedTemplate update(FeedTemplate bean);

	public FeedTemplate deleteById(String id);
	
	public FeedTemplate[] deleteByIds(String[] ids);
	
	public FeedTemplatePage getPage(int pageNo, int pageSize);
	
	
	public Page<FeedTemplate> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<FeedTemplate> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}