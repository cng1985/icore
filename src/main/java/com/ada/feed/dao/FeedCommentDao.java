package com.ada.feed.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.feed.entity.FeedComment;
import com.ada.feed.page.FeedCommentPage;

public interface FeedCommentDao extends BaseDao<FeedComment, Long>{
	Pagination getPage(int pageNo, int pageSize);

	FeedComment findById(Long id);

	FeedComment save(FeedComment bean);

	FeedComment updateByUpdater(Updater<FeedComment> updater);

	FeedComment deleteById(Long id);
	
	FeedCommentPage pageByFeed(long feedid, int pageNo, int pageSize);

}