package com.ada.article.dao;


import  com.ada.article.entity.ArticleComment;
import com.quhaodian.data.core.CriteriaDao;
import com.quhaodian.data.core.Pagination;
import  com.quhaodian.data.core.Updater;

public interface ArticleCommentDao extends CriteriaDao<ArticleComment, Long>{
	Pagination getPage(int pageNo, int pageSize);

	ArticleComment findById(Long id);

	ArticleComment save(ArticleComment bean);

	ArticleComment updateByUpdater(Updater<ArticleComment> updater);

	ArticleComment deleteById(Long id);
}