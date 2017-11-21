package com.ada.article.service;

import com.ada.article.entity.ArticleTag;
import com.ada.article.page.ArticleTagPage;
import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;


public interface ArticleTagService {

	ArticleTag findById(Long id);

	ArticleTag save(ArticleTag bean);

	ArticleTag update(ArticleTag bean);

	ArticleTag deleteById(Long id);
	
	ArticleTag[] deleteByIds(Long[] ids);
	
	ArticleTagPage getPage(int pageNo, int pageSize);
	
	
	Page<ArticleTag> findPage(Pageable pageable);

	long count(Filter... filters);

	List<ArticleTag> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}