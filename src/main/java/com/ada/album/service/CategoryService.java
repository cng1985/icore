package com.ada.album.service;

import com.ada.album.entity.Category;
import com.ada.album.page.CategoryPage;
import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;


public interface CategoryService {

	Category findById(String id);

	Category save(Category bean);

	Category update(Category bean);

	Category deleteById(String id);
	
	Category[] deleteByIds(String[] ids);
	
	CategoryPage getPage(int pageNo, int pageSize);
	
	
	Page<Category> findPage(Pageable pageable);

	long count(Filter... filters);

	List<Category> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}