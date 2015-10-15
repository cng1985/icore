package com.ada.question.service;

import com.ada.data.core.Pagination;
import com.ada.question.entity.QuestionCatalog;
import com.ada.question.page.QuestionCatalogPage;


import com.openyelp.annotation.RestFul;

@RestFul(api=QuestionCatalogService.class,value="QuestionCatalogService")
public interface QuestionCatalogService {
	public QuestionCatalogPage getPage(int pageNo, int pageSize);

	public QuestionCatalog findById(Integer id);

	public QuestionCatalog save(QuestionCatalog bean);

	public QuestionCatalog update(QuestionCatalog bean);

	public QuestionCatalog deleteById(Integer id);
	
	public QuestionCatalog[] deleteByIds(Integer[] ids);
}