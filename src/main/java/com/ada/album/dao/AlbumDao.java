package com.ada.album.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.album.entity.Album;

public interface AlbumDao extends CriteriaDao<Album, String>{
	public Pagination getPage(int pageNo, int pageSize);

	public Album findById(String id);

	public Album save(Album bean);

	public Album updateByUpdater(Updater<Album> updater);

	public Album deleteById(String id);
}