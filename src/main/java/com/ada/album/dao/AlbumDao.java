package com.ada.album.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.album.entity.Album;

public interface AlbumDao extends BaseDao<Album, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public Album findById(Long id);

	public Album save(Album bean);

	public Album updateByUpdater(Updater<Album> updater);

	public Album deleteById(Long id);
}