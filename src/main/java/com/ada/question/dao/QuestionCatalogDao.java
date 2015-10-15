package com.ada.question.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.question.entity.QuestionCatalog;

public interface QuestionCatalogDao extends BaseDao<QuestionCatalog, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public QuestionCatalog findById(Integer id);

	public QuestionCatalog save(QuestionCatalog bean);

	public QuestionCatalog updateByUpdater(Updater<QuestionCatalog> updater);

	public QuestionCatalog deleteById(Integer id);
}