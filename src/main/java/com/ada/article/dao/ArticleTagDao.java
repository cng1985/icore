package com.ada.article.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.article.entity.ArticleTag;

public interface ArticleTagDao extends CriteriaDao<ArticleTag, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public ArticleTag findById(Long id);
	
	public ArticleTag tag(String tag);


	public ArticleTag save(ArticleTag bean);

	public ArticleTag updateByUpdater(Updater<ArticleTag> updater);

	public ArticleTag deleteById(Long id);
}