package com.ada.album.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.album.entity.PhotoFeed;

public interface PhotoFeedDao extends CriteriaDao<PhotoFeed, String>{
	public Pagination getPage(int pageNo, int pageSize);

	public PhotoFeed findById(String id);

	public PhotoFeed save(PhotoFeed bean);

	public PhotoFeed updateByUpdater(Updater<PhotoFeed> updater);

	public PhotoFeed deleteById(String id);
}