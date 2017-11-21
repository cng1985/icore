package com.ada.question.service;

import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import com.ada.question.entity.QuestionAnswer;
import com.ada.question.page.QuestionAnswerPage;



public interface QuestionAnswerService {
	QuestionAnswerPage getPage(int pageNo, int pageSize);

	QuestionAnswer findById(Long id);

	QuestionAnswer save(QuestionAnswer bean);

	QuestionAnswer answer(Long id);

	
	QuestionAnswer update(QuestionAnswer bean);

	QuestionAnswer deleteById(Long id);
	
	QuestionAnswer[] deleteByIds(Long[] ids);
	
	QuestionAnswerPage pageByQuestion(long qid, int pageNo, int pageSize);

	Page<QuestionAnswer> findPage(Pageable pageable);

}