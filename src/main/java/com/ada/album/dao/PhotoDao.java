package com.ada.album.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.album.entity.Photo;

public interface PhotoDao extends CriteriaDao<Photo, String>{
	public Pagination getPage(int pageNo, int pageSize);

	public Photo findById(String id);

	public Photo save(Photo bean);

	public Photo updateByUpdater(Updater<Photo> updater);

	public Photo deleteById(String id);
}