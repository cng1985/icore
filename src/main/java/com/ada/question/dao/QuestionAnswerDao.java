package com.ada.question.dao;


import  com.ada.data.core.BaseDao;
import com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.question.entity.QuestionAnswer;

public interface QuestionAnswerDao extends CriteriaDao<QuestionAnswer, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public QuestionAnswer findById(Long id);

	public QuestionAnswer save(QuestionAnswer bean);

	public QuestionAnswer updateByUpdater(Updater<QuestionAnswer> updater);

	public QuestionAnswer deleteById(Long id);
}