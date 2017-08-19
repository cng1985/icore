package com.ada.article.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.article.entity.SensitiveCategory;

public interface SensitiveCategoryDao extends CriteriaDao<SensitiveCategory,Integer>{
	Pagination getPage(int pageNo, int pageSize);

	SensitiveCategory findById(Integer id);

	SensitiveCategory save(SensitiveCategory bean);

	SensitiveCategory updateByUpdater(Updater<SensitiveCategory> updater);

	SensitiveCategory deleteById(Integer id);
}