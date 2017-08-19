package com.ada.album.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.album.entity.Photo;

public interface PhotoDao extends CriteriaDao<Photo, String>{
	Pagination getPage(int pageNo, int pageSize);

	Photo findById(String id);

	Photo save(Photo bean);

	Photo updateByUpdater(Updater<Photo> updater);

	Photo deleteById(String id);
}