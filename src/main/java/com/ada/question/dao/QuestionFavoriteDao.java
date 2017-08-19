package com.ada.question.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.question.entity.QuestionFavorite;

public interface QuestionFavoriteDao extends BaseDao<QuestionFavorite, Long>{
	Pagination getPage(int pageNo, int pageSize);

	QuestionFavorite findById(Long id);

	QuestionFavorite save(QuestionFavorite bean);

	QuestionFavorite updateByUpdater(Updater<QuestionFavorite> updater);

	QuestionFavorite deleteById(Long id);
}