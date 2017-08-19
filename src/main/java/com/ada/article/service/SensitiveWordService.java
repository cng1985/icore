package com.ada.article.service;

import com.ada.article.entity.SensitiveWord;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


public interface SensitiveWordService {

	SensitiveWord findById(Long id);

	SensitiveWord save(SensitiveWord bean);

	SensitiveWord update(SensitiveWord bean);

	SensitiveWord deleteById(Long id);
	
	SensitiveWord[] deleteByIds(Long[] ids);
	
	Page<SensitiveWord> findPage(Pageable pageable);

	long count(Filter... filters);

	List<SensitiveWord> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}