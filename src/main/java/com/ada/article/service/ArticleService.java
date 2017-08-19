package com.ada.article.service;

import java.util.List;

import com.ada.article.entity.Article;
import com.ada.article.page.ArticlePage;
import com.ada.data.core.Pagination;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;



public interface ArticleService {
	Pagination getPage(int pageNo, int pageSize);

	Article findById(Long id);
	Article view(Long id);

	Article save(Article bean, String... tag);
	
	Article addTag(Long id, String tag);

	Article addTagS(Long id, List<String> tags);
	
	Article resetTagS(Long id, List<String> tags);

	Article update(Article bean);

	Article deleteById(Long id);
	
	Article[] deleteByIds(Long[] ids);
	
	ArticlePage pageByCatalog(int catalog, int pageNo, int pageSize);
	
	ArticlePage pageByCatalog(long uid, int catalog, int pageNo, int pageSize);
	
	Page<Article> findPage(Pageable pageable);



}