package com.ada.album.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.album.entity.PhotoFeed;

public interface PhotoFeedDao extends BaseDao<PhotoFeed, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public PhotoFeed findById(Long id);

	public PhotoFeed save(PhotoFeed bean);

	public PhotoFeed updateByUpdater(Updater<PhotoFeed> updater);

	public PhotoFeed deleteById(Long id);
}