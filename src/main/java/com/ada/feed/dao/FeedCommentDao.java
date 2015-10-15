package com.ada.feed.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.feed.entity.FeedComment;
import com.ada.feed.page.FeedCommentPage;

public interface FeedCommentDao extends BaseDao<FeedComment, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public FeedComment findById(Long id);

	public FeedComment save(FeedComment bean);

	public FeedComment updateByUpdater(Updater<FeedComment> updater);

	public FeedComment deleteById(Long id);
	
	public FeedCommentPage pageByFeed(long feedid,int pageNo, int pageSize);

}