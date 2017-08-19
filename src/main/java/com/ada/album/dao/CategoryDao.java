package com.ada.album.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.album.entity.Category;

public interface CategoryDao extends CriteriaDao<Category, String>{
	Pagination getPage(int pageNo, int pageSize);

	Category findById(String id);

	Category save(Category bean);

	Category updateByUpdater(Updater<Category> updater);

	Category deleteById(String id);
}