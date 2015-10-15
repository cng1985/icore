package com.ada.article.service;

import com.ada.data.core.Pagination;
import com.ada.article.entity.ArticleTag;
import com.openyelp.annotation.RestFul;



@RestFul(api=ArticleTagService.class,value="ArticleTagService")
public interface ArticleTagService {
	public Pagination getPage(int pageNo, int pageSize);

	public ArticleTag findById(Long id);

	public ArticleTag save(ArticleTag bean);

	public ArticleTag update(ArticleTag bean);

	public ArticleTag deleteById(Long id);
	
	public ArticleTag[] deleteByIds(Long[] ids);
}