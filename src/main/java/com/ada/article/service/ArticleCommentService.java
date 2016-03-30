package com.ada.article.service;

import com.ada.article.entity.Article;
import com.ada.article.entity.ArticleComment;
import com.ada.article.page.ArticleCommentPage;
import com.ada.data.core.Pagination;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import com.openyelp.annotation.RestFul;



@RestFul(api=ArticleCommentService.class,value="ArticleCommentService")
public interface ArticleCommentService {
	public Pagination getPage(int pageNo, int pageSize);

	public ArticleComment findById(Long id);

	public ArticleComment save(ArticleComment bean);

	public ArticleComment update(ArticleComment bean);

	public ArticleComment deleteById(Long id);
	
	public ArticleComment[] deleteByIds(Long[] ids);
	public ArticleCommentPage pageByArticle(Long articleid,int pageNo, int pageSize);
	
	public Page<ArticleComment> findPage(Pageable pageable);

}