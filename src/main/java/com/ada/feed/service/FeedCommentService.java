package com.ada.feed.service;

import com.ada.feed.entity.FeedComment;
import com.ada.feed.page.FeedCommentPage;



public interface FeedCommentService {

	FeedComment findById(Long id);

	FeedComment save(FeedComment bean);

	FeedComment update(FeedComment bean);

	FeedComment deleteById(Long id);
	
	FeedComment[] deleteByIds(Long[] ids);
	
	FeedCommentPage getPage(int pageNo, int pageSize);
	
	
	FeedCommentPage pageByFeed(long feedid, int pageNo, int pageSize);

	
}