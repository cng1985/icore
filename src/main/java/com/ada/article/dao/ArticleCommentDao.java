package com.ada.article.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.article.entity.ArticleComment;

public interface ArticleCommentDao extends BaseDao<ArticleComment, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public ArticleComment findById(Long id);

	public ArticleComment save(ArticleComment bean);

	public ArticleComment updateByUpdater(Updater<ArticleComment> updater);

	public ArticleComment deleteById(Long id);
}