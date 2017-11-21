package com.ada.article.service;

import com.ada.article.entity.SensitiveCategory;
import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;


public interface SensitiveCategoryService {

	SensitiveCategory findById(Integer id);

	SensitiveCategory save(SensitiveCategory bean);

	SensitiveCategory update(SensitiveCategory bean);

	SensitiveCategory deleteById(Integer id);
	
	SensitiveCategory[] deleteByIds(Integer[] ids);
	
	Page<SensitiveCategory> findPage(Pageable pageable);

	long count(Filter... filters);

	List<SensitiveCategory> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}