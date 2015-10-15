package com.ada.question.service;

import com.ada.question.entity.QuestionFavorite;
import com.ada.question.page.QuestionFavoritePage;


import com.openyelp.annotation.RestFul;

@RestFul(api=QuestionFavoriteService.class,value="QuestionFavoriteService")
public interface QuestionFavoriteService {

	public QuestionFavorite findById(Long id);
	public QuestionFavorite findByUser(Long uid,Long questionid);

	public QuestionFavorite save(QuestionFavorite bean);

	public QuestionFavorite update(QuestionFavorite bean);

	public QuestionFavorite deleteById(Long id);
	
	public QuestionFavorite[] deleteByIds(Long[] ids);
	
	public QuestionFavoritePage getPage(int pageNo, int pageSize);
	
	public QuestionFavoritePage pageByUser(Long uid,int pageNo, int pageSize);

	public QuestionFavoritePage pageByQuestion(Long qid,int pageNo, int pageSize);

}