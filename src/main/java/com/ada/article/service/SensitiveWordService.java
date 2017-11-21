package com.ada.article.service;

import com.ada.article.entity.SensitiveWord;
import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
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