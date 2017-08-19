package com.ada.question.service;

import com.ada.question.entity.QuestionTag;
import com.ada.question.page.QuestionTagPage;



public interface QuestionTagService {

	QuestionTag findById(Long id);

	QuestionTag save(QuestionTag bean);

	QuestionTag update(QuestionTag bean);

	QuestionTag deleteById(Long id);
	
	QuestionTag[] deleteByIds(Long[] ids);
	
	QuestionTagPage getPage(int pageNo, int pageSize);
	
}