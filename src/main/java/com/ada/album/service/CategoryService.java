package com.ada.album.service;

import com.ada.album.entity.Category;
import com.ada.album.page.CategoryPage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


public interface CategoryService {

	public Category findById(String id);

	public Category save(Category bean);

	public Category update(Category bean);

	public Category deleteById(String id);
	
	public Category[] deleteByIds(String[] ids);
	
	public CategoryPage getPage(int pageNo, int pageSize);
	
	
	public Page<Category> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<Category> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}