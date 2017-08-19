package com.ada.question.service;

import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import com.ada.question.entity.Question;
import com.ada.question.page.QuestionPage;

public interface QuestionService {
	QuestionPage getPage(int pageNo, int pageSize);

	Question findById(Long id);

	Question save(Question bean);

	Question update(Question bean);

	Question deleteById(Long id);
	
	Question[] deleteByIds(Long[] ids);
	
	QuestionPage pageByCatalog(int catalog, int pageNo, int pageSize);
	
	QuestionPage pageByUser(long uid, int pageNo, int pageSize);
	
	QuestionPage pageByType(String type, int pageNo, int pageSize);


	QuestionPage getPageByPid(Long id, int pageNo, int pageSize);

	Page<Question> findPage(Pageable pageable);


}