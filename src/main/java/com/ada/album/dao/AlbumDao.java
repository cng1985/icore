package com.ada.album.dao;


import  com.quhaodian.data.core.CriteriaDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import  com.ada.album.entity.Album;

public interface AlbumDao extends CriteriaDao<Album, String>{
	Pagination getPage(int pageNo, int pageSize);

	Album findById(String id);

	Album save(Album bean);

	Album updateByUpdater(Updater<Album> updater);

	Album deleteById(String id);
}