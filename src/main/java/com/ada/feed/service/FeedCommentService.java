package com.ada.feed.service;

import com.ada.feed.entity.FeedComment;
import com.ada.feed.page.FeedCommentPage;



public interface FeedCommentService {

	public FeedComment findById(Long id);

	public FeedComment save(FeedComment bean);

	public FeedComment update(FeedComment bean);

	public FeedComment deleteById(Long id);
	
	public FeedComment[] deleteByIds(Long[] ids);
	
	public FeedCommentPage getPage(int pageNo, int pageSize);
	
	
	public FeedCommentPage pageByFeed(long feedid,int pageNo, int pageSize);

	
}