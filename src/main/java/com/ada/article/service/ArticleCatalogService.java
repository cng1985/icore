package com.ada.article.service;

import java.util.List;

import com.ada.article.entity.ArticleCatalog;
import com.ada.article.entity.ArticleComment;
import com.ada.data.core.Pagination;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import com.openyelp.annotation.RestFul;



@RestFul(api=ArticleCatalogService.class,value="ArticleCatalogService")
public interface ArticleCatalogService {
	public Pagination getPage(int pageNo, int pageSize);

	public ArticleCatalog findById(Integer id);

	public ArticleCatalog save(ArticleCatalog bean);

	public ArticleCatalog update(ArticleCatalog bean);

	public ArticleCatalog deleteById(Integer id);
	
	public ArticleCatalog[] deleteByIds(Integer[] ids);
	
	List<ArticleCatalog> findChild(int id);
	
	List<ArticleCatalog> all();
	
	
	
	public Pagination pageByPid(int  pid,int pageNo, int pageSize);
	
	public Page<ArticleCatalog> findPage(Pageable pageable);



}