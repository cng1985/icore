package com.ada.question.service;

import com.ada.question.entity.QuestionCatalog;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年05月30日09:15:17.
*/
public interface QuestionCatalogService {

	public QuestionCatalog findById(Integer id);

	public QuestionCatalog save(QuestionCatalog bean);

	public QuestionCatalog update(QuestionCatalog bean);

	public QuestionCatalog deleteById(Integer id);
	
	public QuestionCatalog[] deleteByIds(Integer[] ids);
	
	public Page<QuestionCatalog> findPage(Pageable pageable);
	
	public Page<QuestionCatalog> page(Pageable pageable);
	
	public Page<QuestionCatalog> page(Pageable pageable, Object search);

	public long count(Filter... filters);

	public	List<QuestionCatalog> findByTops(Integer pid);

	public List<QuestionCatalog> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);

	List<QuestionCatalog> findChild(int pid);

	List<QuestionCatalog> findTop(Integer id);
}