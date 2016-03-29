package com.ada.feed.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.feed.entity.FeedTemplate;

public interface FeedTemplateDao extends CriteriaDao<FeedTemplate, String>{
	public Pagination getPage(int pageNo, int pageSize);

	public FeedTemplate findById(String id);

	public FeedTemplate save(FeedTemplate bean);

	public FeedTemplate updateByUpdater(Updater<FeedTemplate> updater);

	public FeedTemplate deleteById(String id);
}