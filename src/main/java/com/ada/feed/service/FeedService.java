package com.ada.feed.service;

import com.ada.feed.entity.Feed;
import com.ada.feed.page.FeedDtoPage;
import com.ada.feed.page.FeedPage;

public interface FeedService {

	Feed findById(Long id);

	Feed save(Feed bean);
	
	Feed push(String template, Object object, Long userid);


	Feed update(Feed bean);

	Feed deleteById(Long id);
	
	Feed[] deleteByIds(Long[] ids);
	
	FeedPage getPage(int pageNo, int pageSize);
	
	
	FeedDtoPage page(int pageNo, int pageSize);

}