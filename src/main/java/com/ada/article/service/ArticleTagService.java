package com.ada.article.service;

import com.ada.article.entity.ArticleTag;
import com.ada.article.page.ArticleTagPage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


public interface ArticleTagService {

	public ArticleTag findById(Long id);

	public ArticleTag save(ArticleTag bean);

	public ArticleTag update(ArticleTag bean);

	public ArticleTag deleteById(Long id);
	
	public ArticleTag[] deleteByIds(Long[] ids);
	
	public ArticleTagPage getPage(int pageNo, int pageSize);
	
	
	public Page<ArticleTag> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<ArticleTag> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}