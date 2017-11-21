package com.ada.feed.service;

import com.ada.feed.entity.FeedTemplate;
import com.ada.feed.page.FeedTemplatePage;
import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;


public interface FeedTemplateService {

	FeedTemplate findById(String id);

	FeedTemplate save(FeedTemplate bean);

	FeedTemplate update(FeedTemplate bean);

	FeedTemplate deleteById(String id);
	
	FeedTemplate[] deleteByIds(String[] ids);
	
	FeedTemplatePage getPage(int pageNo, int pageSize);
	
	
	Page<FeedTemplate> findPage(Pageable pageable);

	long count(Filter... filters);

	List<FeedTemplate> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}