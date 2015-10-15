package com.ada.question.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.question.entity.QuestionFavorite;

public interface QuestionFavoriteDao extends BaseDao<QuestionFavorite, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public QuestionFavorite findById(Long id);

	public QuestionFavorite save(QuestionFavorite bean);

	public QuestionFavorite updateByUpdater(Updater<QuestionFavorite> updater);

	public QuestionFavorite deleteById(Long id);
}