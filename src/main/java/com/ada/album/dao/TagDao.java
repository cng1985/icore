package com.ada.album.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.album.entity.Tag;

public interface TagDao extends CriteriaDao<Tag, String>{
	public Pagination getPage(int pageNo, int pageSize);

	public Tag findById(String id);

	public Tag save(Tag bean);

	public Tag updateByUpdater(Updater<Tag> updater);

	public Tag deleteById(String id);
}