package com.ada.article.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.article.entity.SensitiveCategory;

public interface SensitiveCategoryDao extends CriteriaDao<SensitiveCategory,Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public SensitiveCategory findById(Integer id);

	public SensitiveCategory save(SensitiveCategory bean);

	public SensitiveCategory updateByUpdater(Updater<SensitiveCategory> updater);

	public SensitiveCategory deleteById(Integer id);
}