package com.ada.album.dao;


import  com.quhaodian.data.core.CriteriaDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import  com.ada.album.entity.PhotoFeed;

public interface PhotoFeedDao extends CriteriaDao<PhotoFeed, String>{
	Pagination getPage(int pageNo, int pageSize);

	PhotoFeed findById(String id);

	PhotoFeed save(PhotoFeed bean);

	PhotoFeed updateByUpdater(Updater<PhotoFeed> updater);

	PhotoFeed deleteById(String id);
}