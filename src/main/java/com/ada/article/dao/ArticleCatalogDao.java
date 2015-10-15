package com.ada.article.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.article.entity.ArticleCatalog;

public interface ArticleCatalogDao extends BaseDao<ArticleCatalog, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public ArticleCatalog findById(Integer id);

	public ArticleCatalog save(ArticleCatalog bean);

	public ArticleCatalog updateByUpdater(Updater<ArticleCatalog> updater);

	public ArticleCatalog deleteById(Integer id);
}