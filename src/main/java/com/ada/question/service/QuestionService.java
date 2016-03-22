package com.ada.question.service;

import com.ada.question.entity.Question;
import com.ada.question.page.QuestionPage;
import com.openyelp.annotation.RestFul;

@RestFul(api=QuestionService.class,value="QuestionService")
public interface QuestionService {
	public QuestionPage getPage(int pageNo, int pageSize);

	public Question findById(Long id);

	public Question save(Question bean);

	public Question update(Question bean);

	public Question deleteById(Long id);
	
	public Question[] deleteByIds(Long[] ids);
	
	public QuestionPage pageByCatalog(int catalog,int pageNo, int pageSize);
	
	public QuestionPage pageByUser(long uid,int pageNo, int pageSize);
	
	public QuestionPage pageByType(String type,int pageNo, int pageSize);


	public QuestionPage getPageByPid(Long id, int pageNo, int pageSize);


}