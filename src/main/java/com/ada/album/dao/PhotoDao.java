package com.ada.album.dao;


import  com.quhaodian.data.core.CriteriaDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import  com.ada.album.entity.Photo;

public interface PhotoDao extends CriteriaDao<Photo, String>{
	Pagination getPage(int pageNo, int pageSize);

	Photo findById(String id);

	Photo save(Photo bean);

	Photo updateByUpdater(Updater<Photo> updater);

	Photo deleteById(String id);
}