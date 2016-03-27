package com.ada.question.service;

import com.ada.data.core.Pagination;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import com.ada.question.entity.QuestionAnswer;
import com.ada.question.page.QuestionAnswerPage;


import com.openyelp.annotation.RestFul;

@RestFul(api=QuestionAnswerService.class,value="QuestionAnswerService")
public interface QuestionAnswerService {
	public QuestionAnswerPage getPage(int pageNo, int pageSize);

	public QuestionAnswer findById(Long id);

	public QuestionAnswer save(QuestionAnswer bean);

	public QuestionAnswer answer(Long id);

	
	public QuestionAnswer update(QuestionAnswer bean);

	public QuestionAnswer deleteById(Long id);
	
	public QuestionAnswer[] deleteByIds(Long[] ids);
	
	public QuestionAnswerPage pageByQuestion(long qid,int pageNo, int pageSize);

	public Page<QuestionAnswer> findPage(Pageable pageable);

}