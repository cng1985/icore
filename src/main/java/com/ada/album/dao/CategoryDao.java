package com.ada.album.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.album.entity.Category;

public interface CategoryDao extends BaseDao<Category, String>{
	public Pagination getPage(int pageNo, int pageSize);

	public Category findById(String id);

	public Category save(Category bean);

	public Category updateByUpdater(Updater<Category> updater);

	public Category deleteById(String id);
}