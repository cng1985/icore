package com.ada.feed.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.feed.entity.Feed;
import com.ada.feed.page.FeedCommentPage;

public interface FeedDao extends BaseDao<Feed, Long>{
	Pagination getPage(int pageNo, int pageSize);

	Feed findById(Long id);

	Feed save(Feed bean);

	Feed updateByUpdater(Updater<Feed> updater);

	Feed deleteById(Long id);
	

}