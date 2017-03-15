package com.ada.article.service;

import com.ada.article.entity.SensitiveCategory;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


public interface SensitiveCategoryService {

	public SensitiveCategory findById(Integer id);

	public SensitiveCategory save(SensitiveCategory bean);

	public SensitiveCategory update(SensitiveCategory bean);

	public SensitiveCategory deleteById(Integer id);
	
	public SensitiveCategory[] deleteByIds(Integer[] ids);
	
	public Page<SensitiveCategory> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<SensitiveCategory> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}