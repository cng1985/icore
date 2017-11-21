package com.ada.article.dao;


import  com.quhaodian.data.core.CriteriaDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import  com.ada.article.entity.ArticleTag;

public interface ArticleTagDao extends CriteriaDao<ArticleTag, Long>{
	Pagination getPage(int pageNo, int pageSize);

	ArticleTag findById(Long id);
	
	ArticleTag tag(String tag);


	ArticleTag save(ArticleTag bean);

	ArticleTag updateByUpdater(Updater<ArticleTag> updater);

	ArticleTag deleteById(Long id);
}