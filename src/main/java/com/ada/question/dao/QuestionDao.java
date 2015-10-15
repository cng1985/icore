package com.ada.question.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.question.entity.Question;

public interface QuestionDao extends BaseDao<Question, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public Question findById(Long id);

	public Question save(Question bean);

	public Question updateByUpdater(Updater<Question> updater);

	public Question deleteById(Long id);
}