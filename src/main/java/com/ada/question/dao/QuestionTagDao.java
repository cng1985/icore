package com.ada.question.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.question.entity.QuestionTag;

public interface QuestionTagDao extends BaseDao<QuestionTag, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public QuestionTag findById(Long id);

	public QuestionTag save(QuestionTag bean);

	public QuestionTag updateByUpdater(Updater<QuestionTag> updater);

	public QuestionTag deleteById(Long id);
}