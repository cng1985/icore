package com.ada.album.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.album.entity.Tag;

public interface TagDao extends CriteriaDao<Tag, String>{
	Pagination getPage(int pageNo, int pageSize);

	Tag findById(String id);

	Tag save(Tag bean);

	Tag updateByUpdater(Updater<Tag> updater);

	Tag deleteById(String id);
}