package com.ada.album.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.album.entity.Album;

public interface AlbumDao extends CriteriaDao<Album, String>{
	Pagination getPage(int pageNo, int pageSize);

	Album findById(String id);

	Album save(Album bean);

	Album updateByUpdater(Updater<Album> updater);

	Album deleteById(String id);
}