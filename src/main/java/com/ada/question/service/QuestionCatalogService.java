package com.ada.question.service;

import java.util.List;

import com.ada.admin.entity.Menu;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
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

	public List<QuestionCatalog> findChild(int pid);
	
	public List<QuestionCatalog> findTop(Integer id);
	
	public Page<QuestionCatalog> findPage(Pageable pageable);


}