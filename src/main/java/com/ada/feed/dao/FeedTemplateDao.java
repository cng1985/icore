package com.ada.feed.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.feed.entity.FeedTemplate;

public interface FeedTemplateDao extends CriteriaDao<FeedTemplate, String>{
	Pagination getPage(int pageNo, int pageSize);

	FeedTemplate findById(String id);

	FeedTemplate save(FeedTemplate bean);

	FeedTemplate updateByUpdater(Updater<FeedTemplate> updater);

	FeedTemplate deleteById(String id);
}