package com.ada.question.service;

import com.ada.question.entity.QuestionTag;
import com.ada.question.page.QuestionTagPage;



public interface QuestionTagService {

	public QuestionTag findById(Long id);

	public QuestionTag save(QuestionTag bean);

	public QuestionTag update(QuestionTag bean);

	public QuestionTag deleteById(Long id);
	
	public QuestionTag[] deleteByIds(Long[] ids);
	
	public QuestionTagPage getPage(int pageNo, int pageSize);
	
}