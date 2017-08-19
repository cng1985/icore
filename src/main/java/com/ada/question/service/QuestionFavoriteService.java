package com.ada.question.service;

import com.ada.question.entity.QuestionFavorite;
import com.ada.question.page.QuestionFavoritePage;



public interface QuestionFavoriteService {

	QuestionFavorite findById(Long id);
	QuestionFavorite findByUser(Long uid, Long questionid);

	QuestionFavorite save(QuestionFavorite bean);

	QuestionFavorite update(QuestionFavorite bean);

	QuestionFavorite deleteById(Long id);
	
	QuestionFavorite[] deleteByIds(Long[] ids);
	
	QuestionFavoritePage getPage(int pageNo, int pageSize);
	
	QuestionFavoritePage pageByUser(Long uid, int pageNo, int pageSize);

	QuestionFavoritePage pageByQuestion(Long qid, int pageNo, int pageSize);

}