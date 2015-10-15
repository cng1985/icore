package com.ada.article.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.article.entity.Article;

public interface ArticleDao extends BaseDao<Article, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public Article findById(Long id);

	public Article save(Article bean);

	public Article updateByUpdater(Updater<Article> updater);

	public Article deleteById(Long id);
}