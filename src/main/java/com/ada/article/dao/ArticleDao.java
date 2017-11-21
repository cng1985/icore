package com.ada.article.dao;


import  com.ada.article.entity.Article;
import com.quhaodian.data.core.CriteriaDao;
import com.quhaodian.data.core.Pagination;
import  com.quhaodian.data.core.Updater;

public interface ArticleDao extends CriteriaDao<Article, Long>{
	Pagination getPage(int pageNo, int pageSize);

	Article findById(Long id);

	Article save(Article bean);

	Article updateByUpdater(Updater<Article> updater);

	Article deleteById(Long id);
}