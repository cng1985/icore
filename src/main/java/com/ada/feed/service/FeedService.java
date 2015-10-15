package com.ada.feed.service;

import com.ada.feed.entity.Feed;
import com.ada.feed.page.FeedDtoPage;
import com.ada.feed.page.FeedPage;
import com.openyelp.annotation.RestFul;

@RestFul(api=FeedService.class,value="FeedService")
public interface FeedService {

	public Feed findById(Long id);

	public Feed save(Feed bean);

	public Feed update(Feed bean);

	public Feed deleteById(Long id);
	
	public Feed[] deleteByIds(Long[] ids);
	
	public FeedPage getPage(int pageNo, int pageSize);
	
	
	public FeedDtoPage page(int pageNo, int pageSize);

}