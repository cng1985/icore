package com.ada.album.service;

import com.ada.album.entity.Category;
import com.ada.album.page.CategoryPage;


import com.openyelp.annotation.RestFul;

@RestFul(api=CategoryService.class,value="CategoryService")
public interface CategoryService {

	public Category findById(String id);

	public Category save(Category bean);

	public Category update(Category bean);

	public Category deleteById(String id);
	
	public Category[] deleteByIds(String[] ids);
	
	public CategoryPage getPage(int pageNo, int pageSize);
	
}